package model;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {


	private int id;
	private int idOeuvre;
	protected Visibilite visibilite;

	private List<Fiche> fiches=new ArrayList();
	private String nom;
	



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



	@Override
	public String toString() {
		return "Biblioth�que [visibilite=" + visibilite + ", nom=" + nom + "]";
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
