package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Course;
import projekatTSEO.app.model.CourseTeachers;
import projekatTSEO.app.model.Teacher;
import projekatTSEO.app.repository.TeachingRepository;

@Service
public class TeachingService {

	@Autowired
	TeachingRepository teachingRepository;
	
	public Course findOne(Long id) {
		return teachingRepository.findById(id).orElse(null);
	}
	
	public List<Course> findAll(){
		return teachingRepository.findAll();
	}
	
	public Page<Course> findAll(Pageable page){
		return teachingRepository.findAll(page);
	}
	
	public Course save(Course pp) {
		return teachingRepository.save(pp);
	}
	
	public void remove(Long id) {
		teachingRepository.deleteById(id);
	}
	
	public List<Course> findByTeacher(Teacher profesor){
		return teachingRepository.findByTeacher(profesor);
	}
	
	
}
