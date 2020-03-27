package projekatTSEO.dto;

import projekatTSEO.model.Ispit;

public class IspitDTO {
	
	private int id;
	
	private String nazivPredmeta;
	
	private double brojBodova;
	
	private double kolokvijumBodovi;
	
	private String imeStudenta;
	
	private String prezimeStudenta;
	
	private String imeProfesora;
	
	private String prezimeProfesora;
	
	private double pObavezeBodovi;
	
	private int ocena;
	
	public IspitDTO(Ispit ispit) {
		this(ispit.getId(), ispit.getNazivPredmeta(), ispit.getImeStudenta(), ispit.getPrezimeStudenta(), ispit.getBrojBodova(), ispit.getOcena());
	}
	
	public IspitDTO(int id, String nazivPredmeta, String imeStudenta, String prezimeStudenta, double brojBodova, int ocena) {
		super();
		this.id = id;
		this.nazivPredmeta = nazivPredmeta;
		this.imeStudenta = imeStudenta;
		this.prezimeStudenta = prezimeStudenta;
		this.brojBodova = brojBodova;
		this.ocena = ocena;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	public String getImeStudenta() {
		return imeStudenta;
	}

	public void setImeStudenta(String imeStudenta) {
		this.imeStudenta = imeStudenta;
	}
	
	
	

}
