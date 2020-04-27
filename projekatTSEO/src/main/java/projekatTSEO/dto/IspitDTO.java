package projekatTSEO.dto;

import java.util.Date;
import projekatTSEO.model.Ispit;


public class IspitDTO {
	
	private Long id;
	
	private double brojBodova;
	
	private double kolokvijumBodovi;
	
	private StudentDTO student;
	
	private PredmetDTO predmet;
	
	private IspitPeriodDTO ispitPeriod;
	
	private Date datum;
	
	private String imeStudenta;
	
	private String prezimeStudenta;
	
	private String imeProfesora;
	
	private String prezimeProfesora;
	
	private double pObavezeBodovi;
	
	private int ocena;
	
	public IspitDTO() {
		
	}
	
	public IspitDTO(Ispit ispit) {
		id = ispit.getId();
		brojBodova = ispit.getBrojBodova();
		pObavezeBodovi = ispit.getPObavezeBodovi();
		datum = ispit.getDatum();
		predmet = new PredmetDTO(ispit.getPredmet());
		student = new StudentDTO(ispit.getStudent());
		ispitPeriod = new IspitPeriodDTO(ispit.getIspitPeriod());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public double getBrojBodova() {
		return brojBodova;
	}
	
	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	}
	
	public double getPObavezeBodovi() {
		return pObavezeBodovi;
	}
	public void setPObavezeBodovi(double pObavezeBodovi) {
		this.pObavezeBodovi = pObavezeBodovi;
	}
	
	public Date getDatum() {
		return datum;
	}
	public void setDate(Date datum) {
		this.datum = datum;
	}
	
	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	public IspitPeriodDTO getIspitPeriod() {
		return ispitPeriod;
	}
	
	public void setIspitPeriod(IspitPeriodDTO ispitPeriod) {
		this.ispitPeriod = ispitPeriod;
	}
	
	
	

}
