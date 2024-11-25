package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
@Local
public interface iAuthServis {
    Usuario validarNombre(String nombre);
    Boolean validarContraseña(String igresada,String almacenada);
}
