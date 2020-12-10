package model;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte{
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String mail, String password, String pseudo) {
		super(mail, password, pseudo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [mail=" + mail + ", password=" + password + ", pseudo=" + pseudo + "]";
	}

}