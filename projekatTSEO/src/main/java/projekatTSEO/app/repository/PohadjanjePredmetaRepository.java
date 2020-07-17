package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.PohadjanjePredmeta;
import projekatTSEO.app.model.Predmet;
import projekatTSEO.app.model.Profesor;
import projekatTSEO.app.model.Student;

public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long>{

	List<PohadjanjePredmeta> findByStudent(Student s);
	List<PohadjanjePredmeta> findByProfesor(Profesor s);
	List<PohadjanjePredmeta> findByPredmet(Predmet s);
}
