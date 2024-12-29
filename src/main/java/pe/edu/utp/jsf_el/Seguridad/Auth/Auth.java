package pe.edu.utp.jsf_el.Seguridad.Auth;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lombok.Data;
import pe.edu.utp.jsf_el.Model.entity.usuario;
import pe.edu.utp.jsf_el.Service.iAuthServis;

@Stateless
@Data
public class Auth {
    private usuario uasuarioactivo;
    public  Auth(){
        this.uasuarioactivo = new usuario();
    }
    @EJB
    private  iAuthServis iauth;
    public boolean isvalidar(String nombre, String contraseña){
        uasuarioactivo = iauth.validarNombre(nombre);
        if (uasuarioactivo!=null ){
            return iauth.validarContraseña(contraseña,uasuarioactivo.getPwd()) ;
        }else {
            uasuarioactivo = null;
            return false;
        }
    }
}
