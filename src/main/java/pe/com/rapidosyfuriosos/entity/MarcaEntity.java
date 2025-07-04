// MarcaEntity.java
package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "MarcaEntity")
@Table(name = "marca")
public class MarcaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codmar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nommar", length = 50, nullable = false)
    private String nombre;

    @Column(name = "estmar", nullable = false)
    private boolean estado;
}
