// EmpleadoEntity.java
package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomemp", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apepemp", length = 30, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apememp", length = 30, nullable = false)
    private String apellidoMaterno;

    @Column(name = "dniemp", length = 8, nullable = false)
    private String dni;

    @Column(name = "fecemp", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "diremp", length = 50, nullable = false)
    private String direccion;

    @Column(name = "telemp", length = 7, nullable = false)
    private String telefono;

    @Column(name = "celemp", length = 9, nullable = false)
    private String celular;

    @Column(name = "coremp", length = 40, nullable = false)
    private String correo;

    @Column(name = "sexemp", length = 9, nullable = false)
    private String sexo;

    @Column(name = "usuemp", length = 40, nullable = false)
    private String usuario;

    @Column(name = "claemp", length = 40, nullable = false)
    private String clave;

    @Column(name = "estemp", nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;

    @ManyToOne
    @JoinColumn(name = "codrol", nullable = false)
    private RolEntity rol;
}
