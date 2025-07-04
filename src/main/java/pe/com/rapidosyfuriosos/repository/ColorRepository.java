// ColorRepository.java
package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.ColorEntity;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
    @Query("SELECT c FROM ColorEntity c WHERE c.estado = true")
    List<ColorEntity> findAllCustom();
}
