package projekatTSEO.dto;

import java.util.ArrayList;

import projekatTSEO.model.PredavanjePredmeta;

public class PredavanjePredmetaDTO {
	
	private int id;
	private PredmetDTO predmet;
	private ArrayList<ProfesorDTO> profesori;
	
	
	
	/*
	 * public PredavanjePredmetaDTO(PredavanjePredmeta p) { this(p.getId(),
	 * p.getPredmet(), p.getProfesori()); }
	 */


	public PredavanjePredmetaDTO(int id, PredmetDTO predmet, ArrayList<ProfesorDTO> profesori) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.profesori = profesori;
	}
	
	
	public PredavanjePredmetaDTO() {	}
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	public ArrayList<ProfesorDTO> getProfesori() {
		return profesori;
	}
	public void setProfesori(ArrayList<ProfesorDTO> profesori) {
		this.profesori = profesori;
	}

	
}
