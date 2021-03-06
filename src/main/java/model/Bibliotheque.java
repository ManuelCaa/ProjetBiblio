package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Bibliotheque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//Pourquoi
	private int idOeuvre;
	@OneToOne(mappedBy = "biblio")
	protected Compte compte;
	protected Visibilite visibilite;



	@OneToMany (mappedBy = "biblio")
	private List<Fiche> fiches=new ArrayList();
	private String nom;
	


	public Bibliotheque() {
		
	}
	public Bibliotheque(Visibilite visibilite, String nom) {
		this.visibilite = visibilite;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Visibilite getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}


	public List<Fiche> getFiches() {
		return fiches;
	}



	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}


	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}



	/*public void ajouterFiche() {

	}

	public void modifierFiche() {

	}

	public void supprimerFiche() {

	}
	public void afficherFiche() {

	}*/




}
