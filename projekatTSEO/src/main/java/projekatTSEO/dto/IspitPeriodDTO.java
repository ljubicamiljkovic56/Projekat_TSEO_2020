package projekatTSEO.dto;

import java.util.Date;

import projekatTSEO.model.IspitPeriod;

public class IspitPeriodDTO {
	
	private Long id;
	private String ime;
	private Date startDate;
	private Date endDate;
	
	public IspitPeriodDTO() {
		
	}

	public IspitPeriodDTO(IspitPeriod ispitPeriod) {
		this(ispitPeriod.getId(), ispitPeriod.getIme(), ispitPeriod
				.getStartDate(), ispitPeriod.getEndDate());
	}
	
	public IspitPeriodDTO(Long id, String ime, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.ime = ime;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
}
