package projekatTSEO.dto;

import java.util.HashSet;
import java.util.Set;

import projekatTSEO.app.model.Course;
import projekatTSEO.app.model.Enrollment;
import projekatTSEO.app.model.Exam;


public class CourseDTO {
	
	private Long id;
	private String name;
	//private Integer points;

	
	public CourseDTO() {
		
	}
	
	public CourseDTO(Course predmet) {
		this(predmet.getId(), predmet.getName());
	}
	

	public CourseDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String naziv) {
		this.name = naziv;
	}

	
	
	

}
