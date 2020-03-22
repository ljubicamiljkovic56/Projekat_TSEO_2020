package projekatTSEO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByBrojIndeksa (String brojIndeksa);
	
	List<Student> findByPrezime (String prezime);
}
