package model;

import java.time.LocalDate;

public class Livre extends Oeuvre{
	private int id;
	
	
	private static TypeOeuvre type = TypeOeuvre.livre;
	private int  dureeLecture;
	private String auteur;
	
	public Livre(String titre, String descriptif, String nomFichierImage, int annee, String editeur, LocalDate creeA,
			LocalDate modifieeA, boolean moderationEffectuee, int dureeLecture, String auteur) {
		super(titre, descriptif, nomFichierImage, annee, editeur, creeA, modifieeA, moderationEffectuee);
		this.dureeLecture = dureeLecture;
		this.auteur = auteur;
	}

	public int getDureeLecture() {
		return dureeLecture;
	}

	public void setDureeLecture(int dureeLecture) {
		this.dureeLecture = dureeLecture;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public static TypeOeuvre getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Livre [dureeLecture=" + dureeLecture + ", auteur=" + auteur + "]";
	}
	
	
}
