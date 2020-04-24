package projekatTSEO.dto;

import java.util.ArrayList;
import java.util.Date;
import projekatTSEO.model.PohadjanjePredmeta;

public class PohadjanjePredmetaDTO {

	private Long id;
	private ArrayList<ProfesorDTO> predavaci;
	private ArrayList<StudentDTO> studenti;
	private Date startDate;
	private Date endDate;
	private PredmetDTO predmet;
	
	
	public PohadjanjePredmetaDTO(Long id, ArrayList<ProfesorDTO> predavaci, ArrayList<StudentDTO> studenti, PredmetDTO predmet) {
		super();
		this.id = id;
		this.predavaci = predavaci;
		this.studenti = studenti;
		this.predmet = predmet;
	}
	
	public PohadjanjePredmetaDTO() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
