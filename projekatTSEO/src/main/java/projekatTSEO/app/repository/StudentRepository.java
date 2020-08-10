package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByCardNumber (String cardNumber);
	
	List<Student> findByLastname (String lastname);
}
