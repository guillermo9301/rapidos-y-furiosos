// MarcaEntity.java
package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marca")
@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MarcaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codMarca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomMarca", length = 50, nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
