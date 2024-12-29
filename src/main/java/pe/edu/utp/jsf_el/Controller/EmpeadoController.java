package pe.edu.utp.jsf_el.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import pe.edu.utp.jsf_el.Model.dto.EmpleadoDTO;
import pe.edu.utp.jsf_el.Model.entity.Estados.Areaempleado;
import pe.edu.utp.jsf_el.Model.entity.empleado;
import pe.edu.utp.jsf_el.Model.entity.usuario;
import pe.edu.utp.jsf_el.Seguridad.Auth.Auth;
import pe.edu.utp.jsf_el.Service.iEmpleadoServis;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Named(value = "EmpledoMB")
@RequestScoped
public class EmpeadoController {
    @EJB
    private iEmpleadoServis iempleado;

    private List<empleado> listaempleados;
    private List<EmpleadoDTO> listaguardar;
    private empleado empleadoSeleccionado;
    private EmpleadoDTO empleadodto;
    private List<usuario> usuarios;
    @PostConstruct
    public void init() {
        this.listaempleados = iempleado.lista();
        this.empleadodto = new EmpleadoDTO();
    }

    public void cargarUsuarios(empleado empleado) {
        this.empleadoSeleccionado = empleado;
        this.usuarios = empleado.getUsuarios();
    }
    public Areaempleado[] getAreas() {
        return Areaempleado.values();
    }

    public void guardaruno(EmpleadoDTO empleadodto){
         if(empleadodto != null ){
             iempleado.guardar(empleadodto);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("cliente guardado "));
         }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("no sirve tu webada "));
         }
         init();
        PrimeFaces.current().ajax().update("form1:messages");
    }
    public void guardarlista(){

    }
}
