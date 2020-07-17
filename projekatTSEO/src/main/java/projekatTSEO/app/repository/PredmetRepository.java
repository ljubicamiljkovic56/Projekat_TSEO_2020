package projekatTSEO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {
	
	Predmet findByNaziv (String naziv);

}
