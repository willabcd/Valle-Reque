package pe.edu.utp.jsf_el.Model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.utp.jsf_el.Model.entity.Estados.UsuarioRol;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private pe.edu.utp.jsf_el.Model.entity.empleado empleado;

    @Column(name = "estado")
    private boolean estado;
    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    @Column(name = "pwd")
    private String pwd;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_usuario")
    private UsuarioRol rol;
}
