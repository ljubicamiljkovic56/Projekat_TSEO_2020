package projekatTSEO.dto;

import projekatTSEO.app.model.Course;


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
