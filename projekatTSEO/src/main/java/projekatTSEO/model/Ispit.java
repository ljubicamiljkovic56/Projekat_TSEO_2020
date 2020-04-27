package projekatTSEO.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Ispit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "datum")
	private Date datum;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Predmet predmet;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Student student;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private IspitPeriod ispitPeriod;
	
	@Column(name = "nazivPredmeta")
	private String nazivPredmeta;
	
	@Column(name = "brojBodova")
	private double brojBodova;
	
	@Column(name = "kolokvijumBodovi")
	private double kolokvijumBodovi;
	
	@Column(name = "imeStudenta")
	private String imeStudenta;
	
	@Column(name = "prezimeStudenta")
	private String prezimeStudenta;
	
	@Column(name = "imeProfesora")
	private String imeProfesora;
	
	@Column(name = "prezimeProfesora")
	private String prezimeProfesora;
	
	@Column(name = "pObavezeBodovi")
	private double pObavezeBodovi;
	
	@Column(name = "ocena")
	private int ocena;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	public double getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	
	}
	
	public double getKolokvijumBodovi() {
		return kolokvijumBodovi;
	}

	public void setKolokvijumBodovi(double kolokvijumBodovi) {
		this.kolokvijumBodovi = kolokvijumBodovi;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getImeStudenta() {
		return imeStudenta;
	}

	public void setImeStudenta(String imeStudenta) {
		this.imeStudenta = imeStudenta;
	}
	
	public String getPrezimeStudenta() {
		return prezimeStudenta;
	}

	public void setPrezimeStudenta(String prezimeStudenta) {
		this.prezimeStudenta = prezimeStudenta;
	}
	
	public IspitPeriod getIspitPeriod() {
		return ispitPeriod;
	}

	public void setIspitPeriod(IspitPeriod ispitPeriod) {
		this.ispitPeriod = ispitPeriod;
	}
	
	public String getImeProfesora() {
		return imeProfesora;
	}

	public void setImeProfesora(String imeProfesora) {
		this.imeProfesora = imeProfesora;
	}
	
	public String getPrezimeProfesora() {
		return prezimeProfesora;
	}

	public void setPrezimeProfesora(String prezimeProfesora) {
		this.prezimeProfesora = prezimeProfesora;
	}
	
	public double getPObavezeBodovi() {
		return pObavezeBodovi;
	}

	public void setPObavezeBodovi(double pObavezeBodovi) {
		this.pObavezeBodovi = pObavezeBodovi;
	}
	
	public int getOcena() {
		return ocena;
	}

	public void setocena(int ocena) {
		this.ocena = ocena;
	}
	
}
