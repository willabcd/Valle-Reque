package pe.edu.utp.jsf_el.Model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.utp.jsf_el.Model.entity.Estados.UsuarioRol;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private int id_usuario;
    private int id_empleado;
    private boolean estado;
    private String nombre_usuario;
    private String pwd;
    private UsuarioRol rol;
}
