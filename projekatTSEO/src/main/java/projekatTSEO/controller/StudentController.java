package projekatTSEO.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.service.StudentService;
import projekatTSEO.dto.CourseDTO;
import projekatTSEO.app.model.Exam;
import projekatTSEO.app.model.Enrollment;
import projekatTSEO.app.model.Student;
import projekatTSEO.dto.ExamDTO;
import projekatTSEO.dto.ExamPeriodDTO;
import projekatTSEO.dto.EnrollmentDTO;
import projekatTSEO.dto.StudentDTO;


@RestController
@RequestMapping(value="api/studenti")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudenti() {
		List<Student> students = studentService.findAll();
		//convertuje studente u DTO
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsPage(Pageable page) {
		//page object holds data about pagination and sorting
		//the object is created based on the url parameters "page", "size" and "sort" 
		Page<Student> students = studentService.findAll(page);
		
		//convertuje studente u DTO
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setLastname(studentDTO.getLastname());
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		//student mora postojati
		Student student = studentService.findOne(studentDTO.getId()); 
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		student.setCardNumber(studentDTO.getCardNumber());
		student.setName(studentDTO.getName());
		student.setLastname(studentDTO.getLastname());
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/findCardNumber", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentByCard(
			@RequestParam String cardNumber) {
		Student student = studentService.findByCard(cardNumber);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findLastname", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsByPrezime(
			@RequestParam String lastname) {
		List<Student> students = studentService.findByLastname(lastname);
		//convertuje studente u DTO
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/{studentId}/courses", method = RequestMethod.GET)
	public ResponseEntity<List<EnrollmentDTO>> getStudentoviPredmeti(
			@PathVariable Long studentId) {
		Student student = studentService.findOne(studentId);
		Set<Enrollment> enrollments = student.getEnrollments();
		List<EnrollmentDTO> enrollmentsDTO = new ArrayList<>();
		for (Enrollment pp: enrollments) {
			EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
			enrollmentDTO.setId(pp.getId());
			enrollmentDTO.setStart(pp.getStart());
			enrollmentDTO.setFinish(pp.getFinish());
			enrollmentDTO.setCourse(new CourseDTO(pp.getCourse()));
			//ostavljamo studentsko poilje prazno
			
			enrollmentsDTO.add(enrollmentDTO);
		}
		return new ResponseEntity<>(enrollmentsDTO, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/{studentId}/exams", method = RequestMethod.GET)
//	public ResponseEntity<List<ExamDTO>> getStudentExams(
//			@PathVariable Long studentId) {
//		Student student = studentService.findOne(studentId);
//		Set<Exam> exams = student.getExams();
//		List<ExamDTO> examsDTO = new ArrayList<>();
//		for (Exam i: exams) {
//			ExamDTO examDTO = new ExamDTO();
//			examDTO.setId(i.getId());
//			examDTO.setPoints(i.getPoints());
//			examDTO.setpObavezeBodovi(i.getpObavezeBodovi());
//			examDTO.setDate(i.getDate());
//			examDTO.setCourse(new CourseDTO(i.getCourse()));
//			examDTO.setExamPeriod(new ExamPeriodDTO(i.getExamPeriod()));
//		
//			examsDTO.add(examDTO);
//		}
//		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
//	}

}
