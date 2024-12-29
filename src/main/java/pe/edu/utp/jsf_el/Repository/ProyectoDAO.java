package pe.edu.utp.jsf_el.Repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import pe.edu.utp.jsf_el.Model.entity.proyecto;
import pe.edu.utp.jsf_el.Repository.Persistencia.CrudRepository;
@Stateless
public class ProyectoDAO extends CrudRepository<proyecto> {

    public ProyectoDAO() {
        super(proyecto.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
