package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Uplata;

public interface UplataRepository extends JpaRepository<Uplata, Long> {
	
	//Uplata findById (Long id);
	
	List<Uplata> findAll();

}
