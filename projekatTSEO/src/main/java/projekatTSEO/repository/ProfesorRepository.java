package projekatTSEO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
	
	Profesor findByIme (String ime);
	
	Profesor findByPrezime (String prezime);

}
