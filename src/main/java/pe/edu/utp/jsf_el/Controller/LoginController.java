package pe.edu.utp.jsf_el.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import pe.edu.utp.jsf_el.Model.dto.UsuarioDTO;
import pe.edu.utp.jsf_el.Model.entity.Estados.UsuarioRol;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Seguridad.Auth.Auth;
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
    private Auth auth;

    private String nombreusuario;
    private String contraseña;
    private Usuario usuario;
    private String prueba;
    @PostConstruct
    public void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        this.usuario = (Usuario) externalContext.getSessionMap().get("usuarioSesion");
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public String validar() {
        FacesContext faceContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = faceContext.getExternalContext();
        if (auth.isvalidar(nombreusuario, contraseña)) {
            externalContext.getSessionMap().put("usuarioSesion", auth.getUasuarioactivo());
            return "entrar";
        } else {
            if (auth.getUasuarioactivo() == null ) {
                this.usuario = new Usuario();
                faceContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Usuario incorrecto", "El nombre de usuario no existe."));
            }else {
                faceContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Contraseña incorrecta", "La contraseña ingresada es incorrecta."));
            }
            externalContext.invalidateSession();
            return null;
        }
    }

    public void verificarSesion() {
        FacesContext faceContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = faceContext.getExternalContext();

        if (externalContext.getSessionMap().get("usuarioSesion") == null) {
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String CerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
    }







