package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@DiscriminatorValue("album")
public class Album extends Oeuvre{
	
	
	//@Column(name="Categorie")

	
	private int nombreMorceaux;
	
	
	private String artiste;
	
	
	
	public Album() {
		
		this.typeOeuvre = TypeOeuvre.album;

	}

	public Album(String titre, String descriptif, String nomFichierImage, int annee, String editeur, LocalDate creeA,
			LocalDate modifieeA, boolean moderationEffectuee, int nombreMorceaux, String artiste) {
		super(titre, descriptif, nomFichierImage, annee, editeur, creeA, modifieeA, moderationEffectuee);
		this.nombreMorceaux = nombreMorceaux;
		this.artiste = artiste;
		this.typeOeuvre = TypeOeuvre.album;
	}

	public int getNombreMorceaux() {
		return nombreMorceaux;
	}

	public void setNombreMorceaux(int nombreMorceaux) {
		this.nombreMorceaux = nombreMorceaux;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	

}