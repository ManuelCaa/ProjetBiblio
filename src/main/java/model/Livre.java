package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@DiscriminatorValue("livre ")
public class Livre extends Oeuvre{
	
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	private int  dureeLecture;
	
	
	private String auteur;
	
	
	
	public Livre() {
		this.typeOeuvre = TypeOeuvre.livre;
	
	}

	public Livre(String titre, String descriptif, String nomFichierImage, int annee, String editeur, LocalDate creeA,
			LocalDate modifieeA, boolean moderationEffectuee, int dureeLecture, String auteur) {
		super(titre, descriptif, nomFichierImage, annee, editeur, creeA, modifieeA, moderationEffectuee);
		this.dureeLecture = dureeLecture;
		this.auteur = auteur;
		this.typeOeuvre = TypeOeuvre.livre;
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


	
	
	
}
