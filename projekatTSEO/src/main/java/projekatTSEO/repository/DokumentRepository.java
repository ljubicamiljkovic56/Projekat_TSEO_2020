package projekatTSEO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Dokument;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {

	//Dokument findById(Long id);
	
	List<Dokument> findAll();
}
