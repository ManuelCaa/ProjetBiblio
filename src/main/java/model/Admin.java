package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name= "id",referencedColumnName = "id")
public class Admin extends Compte{
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String mail, String password, String pseudo) {
		super(mail, password, pseudo);
		// TODO Auto-generated constructor stub
	}


}