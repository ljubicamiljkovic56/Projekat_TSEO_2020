package projekatTSEO.dto;

import projekatTSEO.app.model.Admin;

public class AdminDTO {
	
	private Long id;
	
	private String name;
	
	private String lastname;

	public AdminDTO() {
		
	}
	
	public AdminDTO(Admin admin) {
		this(admin.getId(), admin.getName(), admin.getLastname());
	}
	
	
	public AdminDTO(Long id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
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

	public void setName(String ime) {
		this.name = ime;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}
