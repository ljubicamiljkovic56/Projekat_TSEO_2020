package projekatTSEO.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Predmet {
	
	@Id
	@Column(name = "idPredmeta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredmeta;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "bodovi")
	private int bodovi;
	

	public int getIdPredmeta() {
		return idPredmeta;
	}

	public void setIdPredmeta(int idPredmeta) {
		this.idPredmeta = idPredmeta;
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
