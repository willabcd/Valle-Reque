package pe.edu.utp.jsf_el.Controller;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import pe.edu.utp.jsf_el.Model.entity.Cliente;
import pe.edu.utp.jsf_el.Service.iClienteServis;

import java.io.Serializable;

@Getter @Setter
@Named(value = "clienteMB")
@ViewScoped
public class ClienteController implements Serializable {

    @EJB
    private iClienteServis icliente;
    private Cliente cliente;

    public void nuevo(){
        cliente= new Cliente();
    }

    public void  guardarcñi(){
        if (cliente.getId_proyecto()==null){
            icliente.guardar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("cliente guardado "));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("no sirve tu webada "));
        }
        nuevo();
        PrimeFaces.current().executeScript("PF('dlgCliente').hide()");
        PrimeFaces.current().ajax().update("form:messages");
    }
}
