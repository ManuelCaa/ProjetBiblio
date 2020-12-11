package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Suivi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private boolean accepte;
	@ManyToOne
	private Utilisateur follower;
	@ManyToOne
	private Utilisateur following;
	
	public Suivi() {
	}
	public Suivi(boolean accepte, Utilisateur follower, Utilisateur following) {
		this.accepte = accepte;
		this.follower = follower;
		this.following = following;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public boolean isAccepte() {
		return accepte;
	}
	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}
	public Utilisateur getFollower() {
		return follower;
	}
	public void setFollower(Utilisateur follower) {
		this.follower = follower;
	}
	public Utilisateur getFollowing() {
		return following;
	}
	public void setFollowing(Utilisateur following) {
		this.following = following;
	}


}
