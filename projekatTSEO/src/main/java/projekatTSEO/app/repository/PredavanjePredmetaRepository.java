package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.PredavanjePredmeta;
import projekatTSEO.app.model.Profesor;

public interface PredavanjePredmetaRepository extends JpaRepository<PredavanjePredmeta, Long>{

	List<PredavanjePredmeta> findByProfesor(Profesor profesor);	
}
