package projekatTSEO.dto;

import projekatTSEO.app.model.Profesor;

public class ProfesorDTO {
	
	private Long id;
	
	private String ime;
	
	private String prezime;
	
	public ProfesorDTO() {
		
	}
	
	public ProfesorDTO(Profesor profesor) {
		this(profesor.getId(), profesor.getIme(), profesor.getPrezime());
	}

	public ProfesorDTO(Long id, String ime, String prezime) {
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
