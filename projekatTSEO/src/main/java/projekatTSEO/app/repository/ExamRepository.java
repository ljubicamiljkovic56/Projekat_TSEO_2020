package projekatTSEO.app.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatTSEO.app.model.Exam;

@Repository
@ComponentScan(basePackages = "projekatTSEO.app.repository")
public interface ExamRepository extends JpaRepository<Exam, Long> {
	

}
