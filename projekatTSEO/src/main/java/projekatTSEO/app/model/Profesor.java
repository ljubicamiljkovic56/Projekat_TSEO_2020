package projekatTSEO.app.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Profesor extends Korisnik{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "korisnicko_ime")
	private String korisnickoIme;
	
	@Column(name = "lozinka")
	private String lozinka;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "uloga")
	private Uloga uloga;
	
	@Column(name = "zvanje")
	private Zvanje zvanje;
	
	@Column(name = "predaje_predmete")
	private ArrayList<Predmet> predajePredmete;

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getPredajePredmete() {
		return predajePredmete;
	}

	public void setPredajePredmete(ArrayList<Predmet> predajePredmete) {
		this.predajePredmete = predajePredmete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	
	
	

}
