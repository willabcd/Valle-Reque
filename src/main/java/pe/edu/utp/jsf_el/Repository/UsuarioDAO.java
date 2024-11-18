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

    public boolean getValidarUsuario(String nombreUsuario, String password) {
        Query query = em.createNativeQuery("CALL proc_login_usuario(?, ?)");
        query.setParameter(1, nombreUsuario);
        query.setParameter(2, password);
        Boolean isValid = (Boolean) query.getSingleResult();
        return isValid != null && isValid;
    }
}
