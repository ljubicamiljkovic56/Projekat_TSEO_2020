package projekatTSEO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findByName (String name);
	
	Teacher findByLastname (String lastname);

}
