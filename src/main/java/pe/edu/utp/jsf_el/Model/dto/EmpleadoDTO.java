package pe.edu.utp.jsf_el.Model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import pe.edu.utp.jsf_el.Model.entity.Estados.Areaempleado;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmpleadoDTO {
    private int id;
    private String nombre;
    private String apellido;
    private Areaempleado area;
}
