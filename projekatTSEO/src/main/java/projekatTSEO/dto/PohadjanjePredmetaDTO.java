package projekatTSEO.dto;

import java.util.ArrayList;
import java.util.Date;

public class PohadjanjePredmetaDTO {

	private Long id;
	private ArrayList<ProfesorDTO> predavaci;
	private ArrayList<StudentDTO> studenti;
	private Date pocetak;
	private Date kraj;
	private PredmetDTO predmet;
	
	
	public PohadjanjePredmetaDTO(Long id, ArrayList<ProfesorDTO> predavaci, ArrayList<StudentDTO> studenti,
			Date pocetak, Date kraj, PredmetDTO predmet) {
		super();
		this.id = id;
		this.predavaci = predavaci;
		this.studenti = studenti;
		this.pocetak = pocetak;
		this.kraj = kraj;
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
	
	public Date getPocetak() {
		return pocetak;
	}


	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}


	public Date getKraj() {
		return kraj;
	}


	public void setKraj(Date kraj) {
		this.kraj = kraj;
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
