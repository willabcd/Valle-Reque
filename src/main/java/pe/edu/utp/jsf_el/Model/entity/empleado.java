package pe.edu.utp.jsf_el.Model.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.edu.utp.jsf_el.Model.entity.Estados.Areaempleado;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "empleado")
public class empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id;
    @Column(name = "nombre_empleado")
    private String nombre;
    @Column(name = "apellido_empleado")
    private String apellido;
    @Enumerated(EnumType.STRING)
    @Column(name = "area_empleado")
    private Areaempleado area;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER, orphanRemoval = true)
    @Builder.Default
    private List<usuario> usuarios = new ArrayList<>();
}
