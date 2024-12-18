package pe.edu.utp.jsf_el.Dinamismo;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Named(value = "RutasVistas")
@ViewScoped
public class VistasContoller  implements Serializable {

private String VistaActual = "/inicio.xhtml";

public void showInicio(){
    this.VistaActual="/inicio.xhtml";
}
    public void showVentas(){
        this.VistaActual="/ventas.xhtml";
    }
}
