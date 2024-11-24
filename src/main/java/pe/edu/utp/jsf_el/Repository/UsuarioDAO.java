package pe.edu.utp.jsf_el.Repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Repository.Persistencia.CrudRepository;


@Stateless
public class UsuarioDAO extends CrudRepository<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario getValidarUsuario(String nombreUsuario) {
        Query query = em.createNativeQuery("call BuscarXNombre(?)", Usuario.class);
        query.setParameter(1, nombreUsuario);
        return (Usuario) query.getSingleResult();
    }
    public int getIdValido(String nombre){
        Query query = em.createNativeQuery("SELECT BuscarUserID(?) as id",Usuario.class);
        query.setParameter(1,nombre);
        int resultado = query.getSingleResult() == null ? -1 : (int) query.getSingleResult();
        return resultado;
    }
}
