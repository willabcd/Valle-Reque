package pe.edu.utp.jsf_el.Repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import pe.edu.utp.jsf_el.Model.entity.empleado;
import pe.edu.utp.jsf_el.Model.entity.usuario;
import pe.edu.utp.jsf_el.Repository.Persistencia.CrudRepository;

import java.util.List;

@Stateless
public class EmpleadoDAO extends CrudRepository<empleado> {

    public EmpleadoDAO() { super(empleado.class);}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
