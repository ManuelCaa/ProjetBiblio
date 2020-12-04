package model;

import java.time.LocalDate;

public class Fiche {
	
	//private Oeuvre Oeuvre;
	private int id;
	private int note;
	private double duree;
	private Integer lu;

	private String pretee,avis;
	private LocalDate creeA, modifieA;
	private Oeuvre oeuvre;
	private Bibliotheque biblio;

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


	@Override
	public String toString() {
		return "Fiche [id=" + id + ", note=" + note + ", duree=" + duree + ", lu=" + lu + ", pretee=" + pretee
				+ ", avis=" + avis + ", creeA=" + creeA + ", modifieA=" + modifieA + ", oeuvre=" + oeuvre + ", biblio="
				+ biblio + "]";
	}

	
	

	
	
	
	
	

}
