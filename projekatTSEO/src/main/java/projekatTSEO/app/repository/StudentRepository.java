package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByBrojIndeksa (String brojIndeksa);
	
	List<Student> findByPrezime (String prezime);
}
