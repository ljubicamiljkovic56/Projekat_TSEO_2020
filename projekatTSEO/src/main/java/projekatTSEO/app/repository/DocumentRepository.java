package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	//Dokument findById(Long id);
	
	List<Document> findAll();
}
