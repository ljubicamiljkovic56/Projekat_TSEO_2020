package projekatTSEO.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ispit {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
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
