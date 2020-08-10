package projekatTSEO.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Course course;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Student student;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Teacher teacher;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private ExamPeriod examPeriod;
	
	
	private double points;
	
	private double kolokvijumPoints;
	
	private double pObavezeBodovi;
	
	private int grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ExamPeriod getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.examPeriod = examPeriod;
	}


	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public double getKolokvijumPoints() {
		return kolokvijumPoints;
	}

	public void setKolokvijumPoints(double kolokvijumPoints) {
		this.kolokvijumPoints = kolokvijumPoints;
	}


	public double getpObavezeBodovi() {
		return pObavezeBodovi;
	}

	public void setpObavezeBodovi(double pObavezeBodovi) {
		this.pObavezeBodovi = pObavezeBodovi;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Exam(Long id, Date date, Course course, Student student, Teacher teacher, ExamPeriod examPeriod,
			double points, double kolokvijumPoints, double pObavezeBodovi, int grade) {
		super();
		this.id = id;
		this.date = date;
		this.course = course;
		this.student = student;
		this.teacher = teacher;
		this.examPeriod = examPeriod;
		this.points = points;
		this.kolokvijumPoints = kolokvijumPoints;
		this.pObavezeBodovi = pObavezeBodovi;
		this.grade = grade;
	}

	public Exam() {
		super();
	}
	
	
	
}
