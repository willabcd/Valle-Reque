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
@Table(name = "proyecto")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Integer id_proyecto;
    @Column(name = "nombre_proyecto")
    private String nombre_proyecto;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "foto_ref")
    private String foto_ref;
}
