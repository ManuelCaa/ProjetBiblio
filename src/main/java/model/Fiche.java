package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fiche {

	//private Oeuvre Oeuvre;
	@Id
	private int id;
	private int note;
	private double duree;
	private Integer lu;

	private String pretee,avis;
	private LocalDate creeA, modifieA;
	@ManyToOne
	private Oeuvre oeuvre;
	@ManyToOne
	@JoinColumn(name = "biblio")
	private Bibliotheque biblio;

	public Fiche() {
		
	}
	public Fiche(int note, String pretee, int lu, String avis, int duree, LocalDate creeA,
			LocalDate modifieA, Oeuvre oeuvre, Bibliotheque b) {
		this.note = note;
		this.pretee = pretee;
		this.lu = lu;
		this.avis = avis;
		this.duree = duree;
		this.creeA = creeA;
		this.modifieA = modifieA;
		this.oeuvre = oeuvre;
		this.biblio=b;
	}


	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public Integer getLu() {
		return lu;
	}

	public void setLu(Integer lu) {
		this.lu = lu;
	}

	public String getPretee() {
		return pretee;
	}

	public void setPretee(String pretee) {
		this.pretee = pretee;
	}

	public LocalDate getCreeA() {
		return creeA;
	}

	public void setCreeA(LocalDate creeA) {
		this.creeA = creeA;
	}

	public LocalDate getModifieA() {
		return modifieA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public Bibliotheque getBiblio() {
		return biblio;
	}

	public void setModifieA(LocalDate modifieA) {
		this.modifieA = modifieA;
	}




}