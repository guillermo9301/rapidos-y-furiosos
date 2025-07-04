// RolEntity.java
package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "RolEntity")
@Table(name = "rol")
public class RolEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codrol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomrol", length = 40, nullable = false)
    private String nombre;

    @Column(name = "estrol", nullable = false)
    private boolean estado;
}
