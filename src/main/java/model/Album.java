package model;

import java.time.LocalDate;

public class Album extends Oeuvre{
	private int id;
	private TypeOeuvre type = TypeOeuvre.album;
	private int nombreMorceaux;
	private String artiste;
	
	public Album(String titre, String descriptif, String nomFichierImage, int annee, String editeur, LocalDate creeA,
			LocalDate modifieeA, boolean moderationEffectuee, int nombreMorceaux, String artiste) {
		super(titre, descriptif, nomFichierImage, annee, editeur, creeA, modifieeA, moderationEffectuee);
		this.nombreMorceaux = nombreMorceaux;
		this.artiste = artiste;
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

	public TypeOeuvre getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Album [nombreMorceaux=" + nombreMorceaux + ", artiste=" + artiste + "]";
	}
	
}