package model;

import java.util.ArrayList;
import java.util.List;


public class Utilisateur extends Compte {

	private List<Followers> followers= new ArrayList();
	private List<Following> following= new ArrayList();
	
	//oeuvres créées par l'utilisateur
	private List<Oeuvre> oeuvres=new ArrayList();
	
	private Bibliotheque bibliotheque;
	
	public Utilisateur(String mail, String password, String pseudo,Bibliotheque b) {
		super(mail, password, pseudo);
		this.bibliotheque=b;
		// TODO Auto-generated constructor stub
	}

	public List<Followers> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Followers> followers) {
		this.followers = followers;
	}

	public List<Following> getFollowing() {
		return following;
	}

	public void setFollowing(List<Following> following) {
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
		return "Utilisateur [followers=" + followers + ", following=" + following + ", oeuvres=" + oeuvres
				+ ", bibliotheque=" + bibliotheque + "]";
	}

	

	

	
	
	
	
}
