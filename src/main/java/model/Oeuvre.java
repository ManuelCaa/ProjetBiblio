package model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Oeuvre {

	private int id;
	private String titre;
	private String descriptif;
	private String nomFichierImage;
	private int annee;
	private String editeur;
	private LocalDate creeA;
	private LocalDate modifieeA;
	private boolean moderationEffectuee;


	public Oeuvre(String titre, String descriptif, String nomFichierImage, int annee, String editeur, LocalDate creeA,
			LocalDate modifieeA, boolean moderationEffectuee) {
		this.titre = titre;
		this.descriptif = descriptif;
		this.nomFichierImage = nomFichierImage;
		this.annee = annee;
		this.editeur = editeur;
		this.creeA = creeA;
		this.modifieeA = modifieeA;
		this.moderationEffectuee = moderationEffectuee;
	}
	public int getId() {
		return this.id;
	}
		public String getTitre() {
			return titre;
		}


		public void setTitre(String titre) {
			this.titre = titre;
		}


		public String getDescriptif() {
			return descriptif;
		}


		public void setDescriptif(String descriptif) {
			this.descriptif = descriptif;
		}


		public String getNomFichierImage() {
			return nomFichierImage;
		}


		public void setNomFichierImage(String nomFichierImage) {
			this.nomFichierImage = nomFichierImage;
		}


		public int getAnnee() {
			return annee;
		}


		public void setAnnee(int annee) {
			this.annee = annee;
		}


		public String getEditeur() {
			return editeur;
		}


		public void setEditeur(String editeur) {
			this.editeur = editeur;
		}


		public LocalDate getCreeA() {
			return creeA;
		}


		public void setCreeA(LocalDate creeA) {
			this.creeA = creeA;
		}


		public LocalDate getModifieeA() {
			return modifieeA;
		}

		public void setModifieeA(LocalDate modifieeA) {
			this.modifieeA = modifieeA;
		}


		public boolean isModerationEffectuee() {
			return moderationEffectuee;
		}


		public void setModerationEffectuee(boolean moderationEffectuee) {
			this.moderationEffectuee = moderationEffectuee;
		}


		public void setId(int id) {
			this.id = id;
		}
	
		public String toString() {
			return "Oeuvre [id= "+getId()+" titre=" + titre + ", descriptif=" + descriptif + ", nomFichierImage=" + nomFichierImage
			+ ", annee=" + annee + ", editeur=" + editeur + ", creeA=" + creeA + ", modifieeA=" + modifieeA
			+ ", moderationEffectuee=" + moderationEffectuee + "]";



	}}
