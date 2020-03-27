package projekatTSEO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.PredavanjePredmeta;
import projekatTSEO.model.Profesor;

public interface PredavanjePredmetaRepository extends JpaRepository<PredavanjePredmeta, Integer>{

	List<PredavanjePredmeta> findByProfesor(Profesor profesor);	
}
