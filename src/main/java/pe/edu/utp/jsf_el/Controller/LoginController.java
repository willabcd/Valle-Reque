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
import pe.edu.utp.jsf_el.Model.entity.Cliente;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;

import java.io.Serializable;
@Getter
@Setter
@Named(value = "Login")
@ViewScoped
public class LoginController implements Serializable {
    @EJB
    private iUsuarioServis iusuario;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario(); // Inicializamos el objeto Usuario
    }

    public void validar() {
        try {
            // Validar las credenciales del usuario con el servicio
            if (iusuario.validar(usuario.getNombre_usuario(), usuario.getPwd())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Login exitoso",
                                "Bienvenido " + usuario.getNombre_usuario()));
                // Redirigir a la página principal
                PrimeFaces.current().executeScript("window.location = 'home.xhtml';");
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Credenciales incorrectas",
                                "Verifique su usuario o contraseña."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al validar",
                            "Ocurrió un error al intentar iniciar sesión."));
            e.printStackTrace();
        }

        // Actualizar los mensajes en la interfaz
        PrimeFaces.current().ajax().update("loginForm:messages");
    }
}
