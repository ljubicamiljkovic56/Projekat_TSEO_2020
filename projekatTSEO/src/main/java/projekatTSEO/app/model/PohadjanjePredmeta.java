package projekatTSEO.app.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PohadjanjePredmeta {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "pocetak")
	private Date pocetak;
	
	@Column(name = "kraj")
	private Date kraj;
	
	@Column(name = "predmet")
	private Predmet predmet;
	
	@Column(name = "predavaci")
	private ArrayList<Profesor> predavaci;
	
	@Column(name = "studenti")
	private ArrayList<Student> studenti;

	public PohadjanjePredmeta(Long id, Date pocetak, Date kraj, Predmet predmet, ArrayList<Profesor> predavaci,
			ArrayList<Student> studenti) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.predmet = predmet;
		this.predavaci = predavaci;
		this.studenti = studenti;
	}

	public PohadjanjePredmeta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public ArrayList<Profesor> getPredavaci() {
		return predavaci;
	}

	public void setPredavaci(ArrayList<Profesor> predavaci) {
		this.predavaci = predavaci;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	
	
}
