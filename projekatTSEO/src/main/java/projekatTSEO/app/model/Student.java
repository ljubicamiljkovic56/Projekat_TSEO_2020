package projekatTSEO.app.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="card_number", unique = true, nullable = false)
	private String cardNumber;

	private String name;
	
	private String lastname;
	
	@OneToMany(mappedBy = "student_id", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();
	
	@ManyToMany
    @JoinTable(name = "finished_courses",
               joinColumns = @JoinColumn(name="student_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName="id"))
	private Set<Course> passed_courses = new HashSet<Course>();
	
	@ManyToMany
    @JoinTable(name = "unfinished_courses",
               joinColumns = @JoinColumn(name="student_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName="id"))
	private Set<Course> unfinished_courses = new HashSet<Course>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Document> documents = new HashSet<Document>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Payment> payments = new HashSet<Payment>();
	
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Exam> exams = new HashSet<Exam>();


	public Student(Long id, String cardNumber, String name, String lastname, Set<Enrollment> enrollments,
			Set<Course> passed_courses, Set<Course> unfinished_courses, Set<Document> documents, Set<Payment> payments,
			Set<Exam> exams) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.name = name;
		this.lastname = lastname;
		this.enrollments = enrollments;
		this.passed_courses = passed_courses;
		this.unfinished_courses = unfinished_courses;
		this.documents = documents;
		this.payments = payments;
		this.exams = exams;
	}


	public Student() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}


	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}


	public Set<Course> getPassed_courses() {
		return passed_courses;
	}


	public void setPassed_courses(Set<Course> passed_courses) {
		this.passed_courses = passed_courses;
	}


	public Set<Course> getUnfinished_courses() {
		return unfinished_courses;
	}


	public void setUnfinished_courses(Set<Course> unfinished_courses) {
		this.unfinished_courses = unfinished_courses;
	}


	public Set<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}


	public Set<Payment> getPayments() {
		return payments;
	}


	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}


	public Set<Exam> getExams() {
		return exams;
	}


	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}


	

	
	
	
	
}
