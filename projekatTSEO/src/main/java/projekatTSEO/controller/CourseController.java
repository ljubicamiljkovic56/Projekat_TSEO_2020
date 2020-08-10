package projekatTSEO.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.app.model.Course;
import projekatTSEO.dto.CourseDTO;
import projekatTSEO.service.CourseService;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	//nadji sve predmete
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<Course> courses = courseService.findAll();
		List<CourseDTO> courseDTO = new ArrayList<>();
		for (Course pr : courses) {
			courseDTO.add(new CourseDTO(pr));
		}
		return new ResponseEntity<>(courseDTO, HttpStatus.OK);
	}
	
	//nadji predmete po id-u
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id){
		Course course = courseService.findOne(id);
		if(course == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.OK);
	}
	
	//sacuvaj predmet
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO){
		Course course = new Course();
		course.setName(courseDTO.getName());
	
		course = courseService.save(course);
		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.CREATED);	
	}
	
	
	//izmeni predmet
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO){
		Course course = courseService.findOne(courseDTO.getId()); 
		if (course == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		course.setName(courseDTO.getName());
	
		course = courseService.save(course);
		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.OK);	
	}
	
	//obrisi predmet
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
		Course course = courseService.findOne(id);
		if (course != null){
			courseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
