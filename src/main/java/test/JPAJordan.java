package test;

import config.Context;
import model.Admin;

public class JPAJordan {

	public static void main(String[] args) {
		
	Admin a = new Admin();
	a.setMail("jo");
	a.setPassword("p");

	Context.getInstance().getDaoCompte().insert(a);
	a=(Admin) Context.getInstance().getDaoCompte().findById(1);
	System.out.println(a.getBiblio());
	}

}
