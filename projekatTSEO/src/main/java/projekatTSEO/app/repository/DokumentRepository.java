package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Dokument;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {

	//Dokument findById(Long id);
	
	List<Dokument> findAll();
}
