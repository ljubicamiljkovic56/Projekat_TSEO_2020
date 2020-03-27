package projekatTSEO.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PredavanjePredmeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "predmet")
	private Predmet predmet;
	
	@Column(name = "profesori")
	private ArrayList<Profesor> profesori;

	
	
	
	public PredavanjePredmeta(int id, Predmet predmet, ArrayList<Profesor> profesori) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.profesori = profesori;
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

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	
	
}
