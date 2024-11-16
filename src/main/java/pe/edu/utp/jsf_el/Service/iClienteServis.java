package pe.edu.utp.jsf_el.Service;

import jakarta.ejb.Local;
import pe.edu.utp.jsf_el.Model.entity.Cliente;

import java.util.List;
@Local
public interface iClienteServis {
    void guardar(Cliente cliente);
    void borrar(Cliente cliente);
    List<Cliente> lista();
}
