package projekatTSEO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Integer> {
	
	Predmet findByNaziv (String naziv);

}
