package projekatTSEO.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uplata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "uplatilac")
	private Student student;
	
	@Column(name = "svrha_uplate")
	private String svrhaUplate;
	
	@Column(name = "primalac")
	private String primalac;
	
	@Column(name = "sifra_placanja")
	private int sifraPlacanja;
	
	@Column(name = "valuta")
	private String valuta;
	
	@Column(name = "iznos")
	private double iznos;
	
	@Column(name = "racun_primaoca")
	private String racunPrimaoca;
	
	@Column(name = "broj_modela")
	private int brojModela;
	
	@Column(name = "poziv_na_broj")
	private String pozivNaBroj;
	
	@Column(name = "mesto_uplate")
	private String mestoUplate;
	
	@Column(name = "datum_uplate")
	private Date datumUplate;
	
	@Column(name = "datum_valute")
	private Date datumValute;
	
	@Column(name = "potpis")
	private boolean potpis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSvrhaUplate() {
		return svrhaUplate;
	}

	public void setSvrhaUplate(String svrhaUplate) {
		this.svrhaUplate = svrhaUplate;
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public int getSifraPlacanja() {
		return sifraPlacanja;
	}

	public void setSifraPlacanja(int sifraPlacanja) {
		this.sifraPlacanja = sifraPlacanja;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getRacunPrimaoca() {
		return racunPrimaoca;
	}

	public void setRacunPrimaoca(String racunPrimaoca) {
		this.racunPrimaoca = racunPrimaoca;
	}

	public int getBrojModela() {
		return brojModela;
	}

	public void setBrojModela(int brojModela) {
		this.brojModela = brojModela;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public String getMestoUplate() {
		return mestoUplate;
	}

	public void setMestoUplate(String mestoUplate) {
		this.mestoUplate = mestoUplate;
	}

	public Date getDatumUplate() {
		return datumUplate;
	}

	public void setDatumUplate(Date datumUplate) {
		this.datumUplate = datumUplate;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public boolean isPotpis() {
		return potpis;
	}

	public void setPotpis(boolean potpis) {
		this.potpis = potpis;
	}
	
	
}
