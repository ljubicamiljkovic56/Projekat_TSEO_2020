package projekatTSEO.dto;

import java.util.Date;

import projekatTSEO.model.IspitPeriod;

public class IspitPeriodDTO {
	
	private Long id;
	private String naziv;
	private Date pocetakRoka;
	private Date krajRoka;
	
	public IspitPeriodDTO() {
		
	}

	public IspitPeriodDTO(IspitPeriod ispitPeriod) {
		this(ispitPeriod.getId(), ispitPeriod.getNaziv(), ispitPeriod
				.getPocetakRoka(), ispitPeriod.getKrajRoka());
	}
	
	public IspitPeriodDTO(Long id, String naziv, Date pocetakRoka, Date krajRoka) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pocetakRoka = pocetakRoka;
		this.krajRoka = krajRoka;
	}
	
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

	
}
