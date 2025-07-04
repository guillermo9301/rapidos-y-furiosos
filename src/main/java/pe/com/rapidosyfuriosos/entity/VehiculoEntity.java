// VehiculoEntity.java
package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "VehiculoEntity")
@Table(name = "vehiculo")
public class VehiculoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codVehiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "placa", length = 10, nullable = false, unique = true)
    private String placa;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "anioFabricacion", nullable = false)
    private int anioFabricacion;

    @ManyToOne
    @JoinColumn(name = "codMarca", nullable = false)
    private MarcaEntity marca;

    @ManyToOne
    @JoinColumn(name = "codColor", nullable = false)
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "codcli", nullable = false)
    private ClienteEntity cliente;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
