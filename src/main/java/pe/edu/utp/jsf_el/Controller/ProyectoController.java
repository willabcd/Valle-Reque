    package pe.edu.utp.jsf_el.Controller;

    import jakarta.ejb.EJB;
    import jakarta.faces.application.FacesMessage;
    import jakarta.faces.context.FacesContext;
    import jakarta.faces.view.ViewScoped;
    import jakarta.inject.Named;
    import lombok.Getter;
    import lombok.Setter;

    import org.primefaces.PrimeFaces;
    import pe.edu.utp.jsf_el.Model.entity.proyecto;

    import pe.edu.utp.jsf_el.Service.iProyectoServis;

    import java.io.Serializable;

    @Getter @Setter
    @Named(value = "proyectoMB")
    @ViewScoped
    public class ProyectoController implements Serializable {


        @EJB
        private iProyectoServis icliente;
        private pe.edu.utp.jsf_el.Model.entity.proyecto proyecto;

        public void nuevo() {
            proyecto = new proyecto();
        }

        public void guardar() {
            if (proyecto.getId() == null) {
                icliente.guardar(proyecto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("cliente guardado "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("no sirve tu webada "));
            }
            nuevo();
            PrimeFaces.current().executeScript("PF('dlgCliente').hide()");
            PrimeFaces.current().ajax().update("form:messages");
        }
    }
