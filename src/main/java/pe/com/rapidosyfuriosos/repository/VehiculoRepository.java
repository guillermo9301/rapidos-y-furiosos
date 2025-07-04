// VehiculoRepository.java
package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
    @Query("SELECT v FROM VehiculoEntity v WHERE v.estado = true")
    List<VehiculoEntity> findAllCustom();
}
