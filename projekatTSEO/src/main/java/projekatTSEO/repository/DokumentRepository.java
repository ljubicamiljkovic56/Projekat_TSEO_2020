package projekatTSEO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Dokument;

public interface DokumentRepository extends JpaRepository<Dokument, Integer> {

	Dokument findById (int id);
	
	List<Dokument> findAll();
}
