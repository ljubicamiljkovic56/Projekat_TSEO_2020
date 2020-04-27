package projekatTSEO.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
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
	
	@Column(name = "broj_indeksa")
	private String brojIndeksa;
	
	@Column(name = "pohadjanje_predmeta")
	private Set<PohadjanjePredmeta> pohadjanjePredmeta;
	
	@Column(name = "polozeni_predmeti")
	private ArrayList<Predmet> polozeniPredmeti;
	
	@Column(name = "nepolozeni_predmeti")
	private ArrayList<Predmet> nepolozeniPredmeti;
	
	@Column(name = "dokumenta")
	private ArrayList<Dokument> dokumenta;
	
	@Column(name = "uplate")
	private ArrayList<Uplata> uplate;
	
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Ispit> ispiti = new HashSet<Ispit>();

	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public Set<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}


	public void setPohadjanjePredmeta(Set<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}


	public ArrayList<Predmet> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}


	public void setPolozeniPredmeti(ArrayList<Predmet> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}


	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}


	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}


	public ArrayList<Dokument> getDokumenta() {
		return dokumenta;
	}


	public void setDokumenta(ArrayList<Dokument> dokumenta) {
		this.dokumenta = dokumenta;
	}


	public ArrayList<Uplata> getUplate() {
		return uplate;
	}


	public void setUplate(ArrayList<Uplata> uplate) {
		this.uplate = uplate;
	}
	
	public Set<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(Set<Ispit> ispiti) {
		this.ispiti = ispiti;
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
