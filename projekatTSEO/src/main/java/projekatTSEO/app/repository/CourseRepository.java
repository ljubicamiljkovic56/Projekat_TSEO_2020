package projekatTSEO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	Course findByName (String name);

}
