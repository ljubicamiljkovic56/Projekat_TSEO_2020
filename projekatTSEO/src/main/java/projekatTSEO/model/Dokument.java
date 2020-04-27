package projekatTSEO.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dokument {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vrsta_dokumenta")
	private VrstaDokumenta vrstaDokumenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VrstaDokumenta getVrstaDokumenta() {
		return vrstaDokumenta;
	}

	public void setVrstaDokumenta(VrstaDokumenta vrstaDokumenta) {
		this.vrstaDokumenta = vrstaDokumenta;
	}
	
	
}
