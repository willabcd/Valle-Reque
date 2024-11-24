package pe.edu.utp.jsf_el.Service;

import pe.edu.utp.jsf_el.Model.dto.UsuarioDTO;
import pe.edu.utp.jsf_el.Model.entity.Usuario;

public interface iUsuarioServis {
    UsuarioDTO validar(String nombre);
    void guradar(Usuario usuario);
    boolean Auth (String nombre);
}
