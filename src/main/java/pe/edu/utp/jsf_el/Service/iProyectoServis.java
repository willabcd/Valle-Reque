package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.entity.proyecto;

import java.util.List;
@Local
public interface iProyectoServis {
    void guardar(proyecto proyecto);
    void borrar(proyecto proyecto);
    List<proyecto> lista();
}
