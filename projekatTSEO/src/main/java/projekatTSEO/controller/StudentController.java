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

import projekatTSEO.model.Uloga;
import projekatTSEO.model.Ispit;
import projekatTSEO.model.PohadjanjePredmeta;
import projekatTSEO.model.Student;
import projekatTSEO.service.StudentService;
import projekatTSEO.dto.PredmetDTO;
import projekatTSEO.dto.IspitDTO;
import projekatTSEO.dto.IspitPeriodDTO;
import projekatTSEO.dto.PohadjanjePredmetaDTO;
import projekatTSEO.dto.StudentDTO;


@RestController
@RequestMapping(value="api/students")

public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
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
		student.setBrojIndeksa(studentDTO.getBrojIndeksa());
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		
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
		
		student.setBrojIndeksa(studentDTO.getBrojIndeksa());
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		
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
	
	@RequestMapping(value="/findIndeks", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentByCard(
			@RequestParam String brojIndeksa) {
		Student student = studentService.findByCard(brojIndeksa);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findPrezime", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsByPrezime(
			@RequestParam String prezime) {
		List<Student> students = studentService.findByPrezime(prezime);
		//convertuje studente u DTO
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/{studentId}/courses", method = RequestMethod.GET)
	public ResponseEntity<List<PohadjanjePredmetaDTO>> getStudentCourses(
			@PathVariable Long studentId) {
		Student student = studentService.findOne(studentId);
		Set<PohadjanjePredmeta> pohadjanjePredmeta = student.getPohadjanjePredmeta();
		List<PohadjanjePredmetaDTO> pohadjanjePredmetaaDTO = new ArrayList<>();
		for (PohadjanjePredmeta pp: pohadjanjePredmeta) {
			PohadjanjePredmetaDTO pohadjanjePredmetaDTO = new PohadjanjePredmetaDTO();
			pohadjanjePredmetaDTO.setId(pp.getId());
			pohadjanjePredmetaDTO.setStartDate(pp.getStartDate());
			pohadjanjePredmetaDTO.setEndDate(pp.getEndDate());
			pohadjanjePredmetaDTO.setPredmet(new PredmetDTO(pp.getPredmet()));
			//ostavljamo studentsko poilje prazno
			
			pohadjanjePredmetaaDTO.add(pohadjanjePredmetaDTO);
		}
		return new ResponseEntity<>(pohadjanjePredmetaaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{studentId}/ispiti", method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getStudentIspiti(
			@PathVariable Long studentId) {
		Student student = studentService.findOne(studentId);
		Set<Ispit> ispiti = student.getIspiti();
		List<IspitDTO> ispitiDTO = new ArrayList<>();
		for (Ispit i: ispiti) {
			IspitDTO ispitDTO = new IspitDTO();
			ispitDTO.setId(i.getId());
			ispitDTO.setBrojBodova(i.getBrojBodova());
			ispitDTO.setPObavezeBodovi(i.getPObavezeBodovi());
			ispitDTO.setDate(i.getDate());
			ispitDTO.setPredmet(new PredmetDTO(i.getPredmet()));
			ispitDTO.setIspitPeriod(new IspitPeriodDTO(i.getIspitPeriod()));
		
			ispitiDTO.add(ispitDTO);
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}

}
