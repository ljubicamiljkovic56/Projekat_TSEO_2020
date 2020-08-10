package projekatTSEO.app.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Enrollment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date start;
	
	private Date finish;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Course course;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Student student;


	
	public Enrollment() {
		super();
	}


	public Enrollment(Long id, Date start, Date finish, Course course,
			Student student) {
		super();
		this.id = id;
		this.start = start;
		this.finish = finish;
		this.course = course;
		this.student = student;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Student getStudents() {
		return student;
	}


	public void setStudents(Student student) {
		this.student = student;
	}

	
}
