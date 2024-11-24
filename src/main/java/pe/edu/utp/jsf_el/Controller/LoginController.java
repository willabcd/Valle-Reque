package pe.edu.utp.jsf_el.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import pe.edu.utp.jsf_el.Model.dto.UsuarioDTO;
import pe.edu.utp.jsf_el.Model.entity.Estados.UsuarioRol;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Named(value = "Login")
@ViewScoped
public class LoginController implements Serializable {
    @EJB
    private iUsuarioServis iusuario;
    private Usuario usuario;
    private UsuarioDTO usuariodto;
    private List<UsuarioRol> roles = Arrays.asList(UsuarioRol.values());
    private String nombreusuario;
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuariodto = new UsuarioDTO();// Inicializamos el objeto Usuario
    }

    public void guardar() {
        try {
            iusuario.guradar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario guardado "));
            init();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("no se pudo guardar "));
        }
        PrimeFaces.current().ajax().update("form:messages");
    }


}
