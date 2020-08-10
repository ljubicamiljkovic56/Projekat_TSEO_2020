package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Course;
import projekatTSEO.app.model.Teacher;

public interface TeachingRepository extends JpaRepository<Course, Long>{

	List<Course> findByTeacher(Teacher profesor);	
}
