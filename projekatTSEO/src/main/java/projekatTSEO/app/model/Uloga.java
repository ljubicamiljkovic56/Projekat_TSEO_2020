package projekatTSEO.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Uloga {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	String naziv;
	
	@OneToMany(mappedBy = "uloga", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<KorisnikovaUloga> korisnikovaUloga = new HashSet<KorisnikovaUloga>();

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

	public Set<KorisnikovaUloga> getKorisnikovaUloga() {
		return korisnikovaUloga;
	}

	public void setKorisnikovaUloga(Set<KorisnikovaUloga> korisnikovaUloga) {
		this.korisnikovaUloga = korisnikovaUloga;
	}

	

}
