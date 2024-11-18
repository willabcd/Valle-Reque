package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import pe.edu.utp.jsf_el.Repository.UsuarioDAO;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;
@Stateless
public class UsuarioServis implements iUsuarioServis {
    @EJB
    private UsuarioDAO usuarioDAO;

    @Override
    public boolean validar(String usuario,String password) {
        return usuarioDAO.getValidarUsuario(usuario, password);
    }
}
