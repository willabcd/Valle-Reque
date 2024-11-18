package pe.edu.utp.jsf_el.Model.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer ID;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "Nombre", column = @Column(name ="nombre")),
            @AttributeOverride(name = "Apellido", column = @Column(name ="apellido"))
    })
    private persona pesonacliente;

    @Column(name = "correo")
    private String Correo;
    @Column(name = "fecha_registro")
    private String fechaRegistro;
}
