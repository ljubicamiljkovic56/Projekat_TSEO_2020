package projekatTSEO.dto;

import projekatTSEO.model.Predmet;


public class PredmetDTO {
	
	private int id;
	
	private String naziv;
	
	private int bodovi;
	
	public PredmetDTO() {
		
	}
	
	public PredmetDTO(Predmet predmet) {
		this(predmet.getId(), predmet.getNaziv(), predmet.getBodovi());
	}
	

	public PredmetDTO(int id, String naziv, int bodovi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.bodovi = bodovi;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	
	

}
