package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.dto.UsuarioDTO;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
@Local
public interface iUsuarioServis {
    void guradar(Usuario usuario);
    boolean Auth (String nombre);
}
