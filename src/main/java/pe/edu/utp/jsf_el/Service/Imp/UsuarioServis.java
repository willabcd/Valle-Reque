package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.edu.utp.jsf_el.Model.entity.usuario;
import pe.edu.utp.jsf_el.Repository.UsuarioDAO;
import pe.edu.utp.jsf_el.Service.iUsuarioServis;


@Stateless
public class UsuarioServis implements iUsuarioServis {
    @EJB
    private UsuarioDAO usuariodao;

    private final BCryptPasswordEncoder pwdCifrar = new BCryptPasswordEncoder();

    @Override
    public void guradar(usuario usuario) {
        String cifrado = pwdCifrar.encode(usuario.getPwd());
        usuario.setPwd(cifrado);
        usuariodao.GuardarUno(usuario);
    }

    @Override
    public boolean Auth(String nombre) {
        return false;
    }

}
