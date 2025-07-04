// MarcaRepository.java
package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {
    @Query("SELECT m FROM MarcaEntity m WHERE m.estado = true")
    List<MarcaEntity> findAllCustom();
}
