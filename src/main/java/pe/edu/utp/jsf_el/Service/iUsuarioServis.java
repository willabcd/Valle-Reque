package pe.edu.utp.jsf_el.Service;

import pe.edu.utp.jsf_el.Model.entity.Usuario;

public interface iUsuarioServis {
    boolean validar(String usuario,String password);
    void guradar(Usuario usuario);
}
