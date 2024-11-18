package pe.edu.utp.jsf_el.Service.Imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import pe.edu.utp.jsf_el.Model.entity.Proyecto;
import pe.edu.utp.jsf_el.Repository.ProyectoDAO;
import pe.edu.utp.jsf_el.Service.iProyectoServis;

import java.util.List;
@Stateless
public class ProyectoServis implements iProyectoServis {
    @EJB
    private ProyectoDAO clientedao;
    @Override
    public void guardar(Proyecto proyecto) {
        clientedao.GuardarUno(proyecto);
    }
    @Override
    public void borrar(Proyecto proyecto) {
        clientedao.eliminar(proyecto);
    }

    @Override
    public List<Proyecto> lista() {
        return clientedao.Listar();
    }
}
