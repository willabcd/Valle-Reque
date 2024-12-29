package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.entity.usuario;

@Local
public interface iUsuarioServis {
    void guradar(usuario usuario);
    boolean Auth (String nombre);
}
