package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Utilisateur")
public class Utilisateur extends Compte {
	
	
	//oeuvres crees par l'utilisateur
	@OneToMany
	private List<Oeuvre> oeuvres=new ArrayList();
	

	public Utilisateur() {
	
	}

	public Utilisateur(String mail, String password, String pseudo, Bibliotheque b) {
		super(mail, password, pseudo, b);
		
	}


	public List<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(List<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}


	

	
	
	
	
}
