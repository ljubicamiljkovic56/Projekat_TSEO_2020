package projekatTSEO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {
	
	Predmet findByNaziv (String naziv);

}
