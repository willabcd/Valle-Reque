package pe.edu.utp.jsf_el.Seguridad.Auth;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lombok.Data;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Service.iAuthServis;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;

@Stateless
@Data
public class Auth {
    public Usuario uasuarioactivo;
    public  Auth(){
        this.uasuarioactivo = new Usuario();
    }
    @EJB
    private  iAuthServis iauth;
    public boolean isvalidar(String nombre, String contraseña){
        uasuarioactivo = iauth.validarNombre(nombre);
        if (uasuarioactivo!=null){
            return iauth.validarContraseña(contraseña,uasuarioactivo.getPwd()) ;
        }else {
            return false;
        }
    }
}
