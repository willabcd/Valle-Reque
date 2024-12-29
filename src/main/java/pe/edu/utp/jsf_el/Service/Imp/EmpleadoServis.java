package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import pe.edu.utp.jsf_el.Model.dto.EmpleadoDTO;
import pe.edu.utp.jsf_el.Model.entity.empleado;
import pe.edu.utp.jsf_el.Model.entity.usuario;
import pe.edu.utp.jsf_el.Repository.EmpleadoDAO;
import pe.edu.utp.jsf_el.Service.iEmpleadoServis;

import java.util.ArrayList;
import java.util.List;
@Stateless
public class EmpleadoServis  implements iEmpleadoServis {
    @EJB
    private EmpleadoDAO empleadoDAO;
    @Override
    public List<empleado> lista() {
        return empleadoDAO.Listar();
    }

    @Override
    public void guardar(EmpleadoDTO empleadoDTO) {
        empleado em = empleado.builder()
                .nombre(empleadoDTO.getNombre())
                .apellido(empleadoDTO.getApellido())
                .area(empleadoDTO.getArea())
                .build();
        empleadoDAO.GuardarUno(em);
    }

    @Override
    public void aactulisar(EmpleadoDTO empleadoDTO) {

    }

    @Override
    public void guardarlista(List<EmpleadoDTO> lista) {
        List<empleado> list = new ArrayList<>();
        empleado em;
        for (int i=0 ; i<lista.size()-1 ; i++){
           list.add(em = empleado.builder()
                   
                   .build());
        }
    }
}
