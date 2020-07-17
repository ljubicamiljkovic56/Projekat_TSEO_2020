package projekatTSEO.dto;

import projekatTSEO.app.model.Admin;

public class AdminDTO {
	
	private Long id;
	
	private String ime;
	
	private String prezime;

	public AdminDTO() {
		
	}
	
	public AdminDTO(Admin admin) {
		this(admin.getId(), admin.getIme(), admin.getPrezime());
	}
	
	
	public AdminDTO(Long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	

}
