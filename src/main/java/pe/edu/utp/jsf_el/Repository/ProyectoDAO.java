package pe.edu.utp.jsf_el.Repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import pe.edu.utp.jsf_el.Model.entity.Proyecto;
import pe.edu.utp.jsf_el.Repository.Persistencia.CrudRepository;
@Stateless
public class ProyectoDAO extends CrudRepository<Proyecto> {

    public ProyectoDAO() {
        super(Proyecto.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
