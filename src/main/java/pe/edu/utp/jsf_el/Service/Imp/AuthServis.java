package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.edu.utp.jsf_el.Model.entity.Usuario;
import pe.edu.utp.jsf_el.Repository.UsuarioDAO;
import pe.edu.utp.jsf_el.Service.iAuthServis;
@Stateless
public class AuthServis implements iAuthServis {
    @EJB
    private UsuarioDAO usuariodao;
    private final BCryptPasswordEncoder pwdCifrar = new BCryptPasswordEncoder();
    @Override
    public Usuario validarNombre(String nombre) {
        return usuariodao.getValidarUsuario(nombre);
    }

    @Override
    public Boolean validarContraseña(String ingresada, String almacenada) {
        return pwdCifrar.matches(ingresada, almacenada);
    }


}
