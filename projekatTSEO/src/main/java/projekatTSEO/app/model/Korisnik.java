package projekatTSEO.app.model;


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
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "korisnicko_ime")
	private String korisnickoIme;
	
	@Column(name = "lozinka")
	private String lozinka;
	
//
//	private String ime;
//	
//
//	private String prezime;
	

	@Column(name = "uloga")
	private Uloga uloga;
	
	
	@OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<KorisnikovaUloga> korisnikovaUloga = new HashSet<KorisnikovaUloga>();
	

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

//	public String getIme() {
//		return ime;
//	}
//
//	public void setIme(String ime) {
//		this.ime = ime;
//	}
//
//	public String getPrezime() {
//		return prezime;
//	}
//
//	public void setPrezime(String prezime) {
//		this.prezime = prezime;
//	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public Set<KorisnikovaUloga> getKorisnikovaUloga() {
		return korisnikovaUloga;
	}

	public void setKorisnikovaUloga(Set<KorisnikovaUloga> korisnikovaUloga) {
		this.korisnikovaUloga = korisnikovaUloga;
	}
	
	
	

}
