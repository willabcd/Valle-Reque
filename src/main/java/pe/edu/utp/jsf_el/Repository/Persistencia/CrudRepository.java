package pe.edu.utp.jsf_el.Repository.Persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public abstract class CrudRepository<T> implements Repository<T>{
    private final Class<T>entidad;

    public CrudRepository(Class<T> entidad) {
        this.entidad = entidad;
    }

    @PersistenceContext(unitName ="basee")
    protected EntityManager em;

    protected abstract EntityManager getEntityManager();
    @Override
    public List<T> Listar() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery(entidad);
        cq.select(cq.from(entidad));
        return getEntityManager().createQuery(cq).getResultList();
    }
    @Override
    public void GuardarUno(T objeto){
        getEntityManager().persist(objeto);
    };
    @Override
    public void GuardarLista(List<T> listaobjetos) {
        for (T objeto : listaobjetos) {
            getEntityManager().persist(objeto);
        }
    }
    @Override
    public void eliminar(T objeto){
        getEntityManager().remove(getEntityManager().merge(objeto));
    };
    @Override
    public T BusacarUno(Object id){
        return getEntityManager().find(entidad,id);
    };
}
