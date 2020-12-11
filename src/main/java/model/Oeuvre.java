package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_oeuvre")
public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	
	@Column(name="Description",columnDefinition="VARCHAR(80)")
	private String descriptif;
	
	@Column(name="Image")
	private String nomFichierImage;
	
	private int annee;
	@OneToOne
	private Utilisateur utilisateur;
	private String editeur;
	
	@Column(columnDefinition = "DATE", name="CreeLe")
	private LocalDate creeA;
	
	@Column(columnDefinition = "DATE", name="ModifieLe")
	private LocalDate modifieeA;
	
	private boolean moderationEffectuee;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Categorie", nullable=false,columnDefinition="VARCHAR(50)")
	protected TypeOeuvre typeOeuvre;
	
	@OneToMany(mappedBy = "oeuvre")
	private List<Fiche> fiches = new ArrayList<>();
	
	
	public Oeuvre() {
		
	}
	
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
	
		
	}
