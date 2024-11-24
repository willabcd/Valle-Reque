package pe.edu.utp.jsf_el.Repository.Persistencia;

import jakarta.ejb.Local;

import java.util.List;
@Local
public interface Repository<T> {
    List<T> Listar();
    void GuardarUno(T objeto);
    T BusacarUno(Object id);
    void GuardarLista(List<T> listaobjetos);
    void eliminar(T objeto);
}
