package projekatTSEO.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "bodovi")
	private int bodovi;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
