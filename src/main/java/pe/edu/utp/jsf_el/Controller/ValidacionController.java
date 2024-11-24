package pe.edu.utp.jsf_el.Controller;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;

import java.io.Serializable;

@Getter
@Setter
@Named(value = "validaMG")
@ViewScoped
public class ValidacionController implements Serializable {

    private String nombreusuario;
    private String Contraseña;
    private String mesaje;

    @EJB
    private iUsuarioServis iusuario;



}
