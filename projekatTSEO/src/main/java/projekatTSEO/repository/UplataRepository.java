package projekatTSEO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Uplata;

public interface UplataRepository extends JpaRepository<Uplata, Integer> {
	
	Uplata findById (int id);
	
	List<Uplata> findAll();

}
