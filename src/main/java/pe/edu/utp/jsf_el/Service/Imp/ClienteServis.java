package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import pe.edu.utp.jsf_el.Model.entity.Cliente;
import pe.edu.utp.jsf_el.Repository.ClienteDAO;
import pe.edu.utp.jsf_el.Service.iClienteServis;

import java.util.List;
@Stateless
public class ClienteServis implements iClienteServis {
    @EJB
    private ClienteDAO clientedao;
    @Override
    public void guardar(Cliente cliente) {
        clientedao.GuardarUno(cliente);
    }
    @Override
    public void borrar(Cliente cliente) {
        clientedao.eliminar(cliente);
    }

    @Override
    public List<Cliente> lista() {
        return clientedao.Listar();
    }
}
