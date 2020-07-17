package projekatTSEO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
	
	Profesor findByIme (String ime);
	
	Profesor findByPrezime (String prezime);

}
