package projekatTSEO.app.model;

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
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
//	private int points;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Exam> exams = new HashSet<Exam>();
		
	@ManyToMany
    @JoinTable(name = "teaching",
               joinColumns = @JoinColumn(name="course_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="teacher_id", referencedColumnName="id"))
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Course(Long id, String name, Set<Enrollment> enrollments, Set<Exam> exams,
			Set<Teacher> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.enrollments = enrollments;
		this.exams = exams;
		this.teachers = teachers;
	}

	public Course() {
		super();
	}
	

	
	
	
	
	

}
