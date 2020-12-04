package model;

public class Admin extends Compte{

	public Admin(String mail, String password, String pseudo) {
		super(mail, password, pseudo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [mail=" + mail + ", password=" + password + ", pseudo=" + pseudo + "]";
	}

}
