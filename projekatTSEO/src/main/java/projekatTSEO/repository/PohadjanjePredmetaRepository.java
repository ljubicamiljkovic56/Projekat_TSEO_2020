package projekatTSEO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.PohadjanjePredmeta;
import projekatTSEO.model.Predmet;
import projekatTSEO.model.Profesor;
import projekatTSEO.model.Student;

public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long>{

	List<PohadjanjePredmeta> findByStudent(Student s);
	List<PohadjanjePredmeta> findByProfesor(Profesor s);
	List<PohadjanjePredmeta> findByPredmet(Predmet s);
}
