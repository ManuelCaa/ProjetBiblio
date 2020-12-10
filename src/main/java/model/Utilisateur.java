package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur extends Compte {
	@OneToMany(mappedBy = "following")
	private List<Suivi> followers= new ArrayList();
	@OneToMany(mappedBy = "follower") //qui suis-je par rapport à cette liste
	private List<Suivi> followings= new ArrayList();
	
	//oeuvres crees par l'utilisateur
	@OneToMany
	private List<Oeuvre> oeuvres=new ArrayList();
	
	@OneToOne
	private Bibliotheque bibliotheque;
	public Utilisateur() {
		
	}
	public Utilisateur(String mail, String password, String pseudo,Bibliotheque b) {
		super(mail, password, pseudo);
		this.bibliotheque=b;
		// TODO Auto-generated constructor stub
	}

	public List<Suivi> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Suivi> followers) {
		this.followers = followers;
	}

	public List<Suivi> getFollowing() {
		return following;
	}

	public void setFollowing(List<Suivi> following) {
		this.following = following;
	}

	public List<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(List<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String toString() {
		return "Utilisateur [followers=" + followers + ", following=" + followings + ", oeuvres=" + oeuvres
				+ ", bibliotheque=" + bibliotheque + "]";
	}

	

	

	
	
	
	
}
