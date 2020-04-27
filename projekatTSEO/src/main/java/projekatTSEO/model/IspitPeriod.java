package projekatTSEO.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
public class IspitPeriod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "pocetak_roka")
	private Date pocetakRoka;
	
	@Column(name = "kraj_roka")
	private Date krajRoka;
	
	@OneToMany(mappedBy = "ispitPeriod", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Ispit> ispiti = new HashSet<Ispit>();

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

	public Date getPocetakRoka() {
		return pocetakRoka;
	}

	public void setPocetakRoka(Date pocetakRoka) {
		this.pocetakRoka = pocetakRoka;
	}

	public Date getKrajRoka() {
		return krajRoka;
	}

	public void setKrajRoka(Date krajRoka) {
		this.krajRoka = krajRoka;
	}
	
	public Set<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(Set<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IspitPeriod e = (IspitPeriod) o;
        if(e.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, e.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

	@Override
	public String toString() {
		return "IspitPeriod [id=" + id + ", naziv=" + naziv + ", pocetakRoka=" + pocetakRoka + ", krajRoka=" + krajRoka
				+ ", ispiti=" + ispiti + "]";
	}


}
