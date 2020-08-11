package projekatTSEO.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.service.ExamService;
import projekatTSEO.service.ExamPeriodService;
import projekatTSEO.app.model.Exam;
import projekatTSEO.app.model.ExamPeriod;
import projekatTSEO.app.model.Course;
import projekatTSEO.app.model.Student;
import projekatTSEO.dto.ExamDTO;

import projekatTSEO.service.StudentService;
import projekatTSEO.service.CourseService;

@RestController
@RequestMapping(value = "/api/exams")
public class ExamController {
	
	@Autowired
	private ExamService examService;

	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;

	@Autowired
	ExamPeriodService examPeriodService;
	
//	
//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//	public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO examDTO) {
//		// ispit mora imati studente predmet i period
//		if (examDTO.getStudent() == null || examDTO.getCourse() == null
//				|| examDTO.getExamPeriod() == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		Student student = studentService.findOne(examDTO.getStudent().getId());
//		Course course = courseService.findOne(examDTO.getCourse().getId());
//		ExamPeriod examPeriod = examPeriodService.findOne(examDTO
//				.getExamPeriod().getId());
//		if (student == null || course == null || examPeriod == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		Exam exam = new Exam();
//		exam.setDate(examDTO.getDate());
//		exam.setPoints(examDTO.getPoints());
//		exam.setpObavezeBodovi(examDTO.getpObavezeBodovi());
//		exam.setStudent(student);
//		exam.setCourse(course);
//		exam.setExamPeriod(examPeriod);
//
//		exam = examService.save(exam);
//		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.CREATED);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
//	public ResponseEntity<ExamDTO> updateIspit(@RequestBody ExamDTO examDTO) {
//		// provara postojanja ispita
//		Exam exam = examService.findOne(examDTO.getId());
//		if (exam == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		// promena datuma i bodova na ispitu
//		exam.setDate(examDTO.getDate());
//		exam.setPoints(examDTO.getPoints());
//		exam.setpObavezeBodovi(examDTO.getpObavezeBodovi());
//
//		exam = examService.save(exam);
//		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
//		Exam exam = examService.findOne(id);
//		if (exam != null) {
//			examService.remove(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
}
