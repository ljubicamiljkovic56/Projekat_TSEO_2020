package projekatTSEO.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PohadjanjePredmeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Predmet predmet;
	
	@Column
	private ArrayList<Profesor> predavaci;
	
	@Column
	private ArrayList<Student> studenti;

	public PohadjanjePredmeta(int id, Predmet predmet, ArrayList<Profesor> predavaci, ArrayList<Student> studenti) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.predavaci = predavaci;
		this.studenti = studenti;
	}

	public PohadjanjePredmeta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
