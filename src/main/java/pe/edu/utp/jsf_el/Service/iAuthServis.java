package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.entity.usuario;
@Local
public interface iAuthServis {
    usuario validarNombre(String nombre);
    Boolean validarContraseña(String igresada,String almacenada);
}
