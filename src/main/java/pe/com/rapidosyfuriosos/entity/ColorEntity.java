// ColorEntity.java
package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ColorEntity")
@Table(name = "color")
public class ColorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcolor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomcolor", length = 30, nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
