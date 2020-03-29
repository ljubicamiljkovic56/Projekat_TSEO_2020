package projekatTSEO.dto;

import java.util.ArrayList;

public class PohadjanjePredmetaDTO {

	private int id;
	private ArrayList<ProfesorDTO> predavaci;
	private ArrayList<StudentDTO> studenti;
	
	
	public PohadjanjePredmetaDTO(int id, ArrayList<ProfesorDTO> predavaci, ArrayList<StudentDTO> studenti) {
		super();
		this.id = id;
		this.predavaci = predavaci;
		this.studenti = studenti;
	}
	
	public PohadjanjePredmetaDTO() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<ProfesorDTO> getPredavaci() {
		return predavaci;
	}
	public void setPredavaci(ArrayList<ProfesorDTO> predavaci) {
		this.predavaci = predavaci;
	}
	public ArrayList<StudentDTO> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<StudentDTO> studenti) {
		this.studenti = studenti;
	}
	
	
	
}
