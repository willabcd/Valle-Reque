package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Repository.UsuarioDAO;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;
@Stateless
public class UsuarioServis implements iUsuarioServis {
    @EJB
    private UsuarioDAO usuarioDAO;
    private final BCryptPasswordEncoder pwdCifrar = new BCryptPasswordEncoder();
    @Override
    public boolean validar(String usuario,String password) {
        return usuarioDAO.getValidarUsuario(usuario, password);
    }

    @Override
    public void guradar(Usuario usuario) {
        String cifrado = pwdCifrar.encode(usuario.getPwd());
        usuario.setPwd(cifrado);
        usuarioDAO.GuardarUno(usuario);
    }
}
