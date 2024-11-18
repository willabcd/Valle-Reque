package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.entity.Proyecto;

import java.util.List;
@Local
public interface iProyectoServis {
    void guardar(Proyecto proyecto);
    void borrar(Proyecto proyecto);
    List<Proyecto> lista();
}
