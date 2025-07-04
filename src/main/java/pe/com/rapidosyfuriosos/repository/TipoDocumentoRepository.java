package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {
	@Query("select td from TipoDocumentoEntity td where td.estado=true")
	 List<TipoDocumentoEntity> findAllCustom();
}