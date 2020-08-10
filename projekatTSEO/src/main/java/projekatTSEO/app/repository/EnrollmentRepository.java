package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Enrollment;
import projekatTSEO.app.model.Course;
import projekatTSEO.app.model.Teacher;
import projekatTSEO.app.model.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

	List<Enrollment> findByStudent(Student s);
	List<Enrollment> findByTeacher(Teacher s);
	List<Enrollment> findByCourse(Course s);
}
