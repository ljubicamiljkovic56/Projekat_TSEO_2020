package projekatTSEO.dto;

import java.util.Date;

import projekatTSEO.app.model.Exam;


public class ExamDTO {
	
	private Long id;	
	private Date date;	
	private CourseDTO course;	
	private StudentDTO student;
	private TeacherDTO teacher;
	private ExamPeriodDTO examPeriod;	
	private double points;	
	private double kolokvijumpoints;	
	private double pObavezeBodovi;	
	private int grade;
	
	
	
	public ExamDTO() {
		
	}
	
	public ExamDTO(Exam ispit) {
		id = ispit.getId();
		points = ispit.getPoints();
		pObavezeBodovi = ispit.getpObavezeBodovi();
		date = ispit.getDate();
		course = new CourseDTO(ispit.getCourse());
		student = new StudentDTO(ispit.getStudent());
		examPeriod = new ExamPeriodDTO(ispit.getExamPeriod());
		grade = ispit.getGrade();
		teacher = new TeacherDTO(ispit.getTeacher());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public double getKolokvijumpoints() {
		return kolokvijumpoints;
	}

	public void setKolokvijumpoints(double kolokvijumpoints) {
		this.kolokvijumpoints = kolokvijumpoints;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	public ExamPeriodDTO getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriodDTO examPeriod) {
		this.examPeriod = examPeriod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}
	
	
	
	

}
