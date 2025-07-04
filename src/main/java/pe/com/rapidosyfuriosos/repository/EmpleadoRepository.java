// EmpleadoRepository.java
package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
    @Query("SELECT e FROM EmpleadoEntity e WHERE e.estado = true")
    List<EmpleadoEntity> findAllCustom();
}
