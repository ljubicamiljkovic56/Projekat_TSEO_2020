package projekatTSEO.app.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PredavanjePredmeta {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "predmet")
	private Predmet predmet;
	
	@Column(name = "profesori")
	private ArrayList<Profesor> profesori;

	
	
	public PredavanjePredmeta(Long id, Predmet predmet, ArrayList<Profesor> profesori) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.profesori = profesori;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
