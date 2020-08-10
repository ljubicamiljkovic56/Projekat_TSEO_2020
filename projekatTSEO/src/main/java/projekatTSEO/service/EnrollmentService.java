package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Enrollment;
import projekatTSEO.app.model.Course;
import projekatTSEO.app.model.Teacher;
import projekatTSEO.app.model.Student;
import projekatTSEO.app.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	public List<Enrollment> findAll(){
		return enrollmentRepository.findAll();
	}
	
	public Page<Enrollment> findAll(Pageable page){
		return enrollmentRepository.findAll(page);
	}
	
	public Enrollment findOne(Long id) {
		return enrollmentRepository.findById(id).orElse(null);
	}
	
	public List<Enrollment> findByStudent(Student s){
		return enrollmentRepository.findByStudent(s);
	}
	
	public List<Enrollment> findByTeacher(Teacher s){
		return enrollmentRepository.findByTeacher(s);
	}
	
	public List<Enrollment> findByCourse(Course s){
		return enrollmentRepository.findByCourse(s);
	}
	
	public Enrollment save(Enrollment p) {
		return enrollmentRepository.save(p);
	}
	
	public void remove(Long id) {
		enrollmentRepository.deleteById(id);;
	}
	
}
