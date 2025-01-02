package pe.edu.utp.jsf_el.Model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.edu.utp.jsf_el.Model.entity.Estados.Areaempleado;
import pe.edu.utp.jsf_el.Model.entity.Herencia.persona;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
@Table(name = "empleado")
@AttributeOverrides({
        @AttributeOverride(name = "nombre", column = @Column(name = "nombre_empleado")),
        @AttributeOverride(name = "apellido", column = @Column(name = "apellido_empleado")),
        @AttributeOverride(name = "doc_identidad", column = @Column(name = "doc_identidad"))
})
public class empleado extends persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "area_empleado")
    private Areaempleado area;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER, orphanRemoval = true)
    @Builder.Default
    private List<usuario> usuarios = new ArrayList<>();
}
