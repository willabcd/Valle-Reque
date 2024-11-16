package pe.edu.utp.jsf_el.Repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import pe.edu.utp.jsf_el.Model.entity.Cliente;
import pe.edu.utp.jsf_el.Repository.Persistencia.CrudRepository;
@Stateless
public class ClienteDAO extends CrudRepository<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }



}
