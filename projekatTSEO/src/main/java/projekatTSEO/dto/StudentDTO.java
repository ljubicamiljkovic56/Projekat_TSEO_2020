package projekatTSEO.dto;

import projekatTSEO.app.model.Student;

public class StudentDTO {
	
	private Long id;
	
	private String brojIndeksa;
	
	private String ime;
	
	private String prezime;
	
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(Student student) {
		this(student.getId(), student.getBrojIndeksa(), student.getIme(), student.getPrezime());
	}

	public StudentDTO(Long id, String brojIndeksa, String ime, String prezime) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
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
