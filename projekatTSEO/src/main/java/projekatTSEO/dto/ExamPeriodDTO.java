package projekatTSEO.dto;

import java.util.Date;

import projekatTSEO.app.model.ExamPeriod;

public class ExamPeriodDTO {
	
	private Long id;
	private String name;
	private Date periodStart;
	private Date periodEnd;
	
	public ExamPeriodDTO() {
		
	}

	public ExamPeriodDTO(ExamPeriod ispitPeriod) {
		this(ispitPeriod.getId(), ispitPeriod.getName(), ispitPeriod
				.getPeriodStart(), ispitPeriod.getPeriodEnd());
	}

	public ExamPeriodDTO(Long id, String name, Date periodStart, Date periodEnd) {
		super();
		this.id = id;
		this.name = name;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}
	
	
	
}
