package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.dto.EmpleadoDTO;
import pe.edu.utp.jsf_el.Model.entity.empleado;
import pe.edu.utp.jsf_el.Model.entity.usuario;

import java.util.List;
@Local
public interface iEmpleadoServis {
    List<empleado> lista();
    void guardar(EmpleadoDTO empleadoDTO);
    void aactulisar(EmpleadoDTO empleadoDTO);
    void  guardarlista(List<EmpleadoDTO> lista);
}
