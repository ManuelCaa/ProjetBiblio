package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Compte{
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String mail, String password, String pseudo, Bibliotheque b) {
		super(mail, password, pseudo, b);
		// TODO Auto-generated constructor stub
	}
	


}