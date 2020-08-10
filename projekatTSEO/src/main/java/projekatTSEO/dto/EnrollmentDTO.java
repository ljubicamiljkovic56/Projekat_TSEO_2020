package projekatTSEO.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class EnrollmentDTO {

	private Long id;
//	private Set<TeacherDTO> teachers;
	private StudentDTO students;
	private Date start;
	private Date finish;
	private CourseDTO course;
	
	

	public EnrollmentDTO() {
		super();
	}


	public EnrollmentDTO(Long id, StudentDTO students, Date start, Date finish,
			CourseDTO course) {
		super();
		this.id = id;
		//this.teachers = teachers;
		this.students = students;
		this.start = start;
		this.finish = finish;
		this.course = course;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public StudentDTO getStudents() {
		return students;
	}


	public void setStudents(StudentDTO students) {
		this.students = students;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getFinish() {
		return finish;
	}


	public void setFinish(Date finish) {
		this.finish = finish;
	}


	public CourseDTO getCourse() {
		return course;
	}


	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	
	
	
}
