package test;

import java.util.Scanner;

import config.Context;
import dao.jpa.DAOAdminJPA;
import dao.jpa.DAOAlbumJPA;
import dao.jpa.DAOBibliothequeJPA;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOFicheJPA;
import dao.jpa.DAOLivreJPA;
import dao.jpa.DAOOeuvreJPA;
import dao.jpa.DAOSuiviJPA;
import dao.jpa.DAOUtilisateurJPA;
import model.Admin;
import model.Compte;

public class testDaoCompte {
	public static int saisieInt(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}


	public static String saisieString(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static void main(String[] args) {
		DAOAdminJPA daoAdmin= new DAOAdminJPA();
		DAOAlbumJPA daoAlbum = new DAOAlbumJPA();
		DAOBibliothequeJPA daoBiblio = new DAOBibliothequeJPA();
		DAOCompteJPA daoCompte = new DAOCompteJPA();
		DAOFicheJPA daoFiche = new DAOFicheJPA();
		DAOLivreJPA daoLivre = new DAOLivreJPA();
		DAOOeuvreJPA daoOeuvre = new DAOOeuvreJPA();
		DAOSuiviJPA daoSuivi = new DAOSuiviJPA();
		DAOUtilisateurJPA daoUtilisateur = new DAOUtilisateurJPA();
		
		
		/*for(Compte cll : Context.getInstance().getDaoCompte().findAll()) {
			System.out.println(cll);}*/
		
		int choix=saisieInt("Choisir (id)");
		Compte c= Context.getInstance().getDaoCompte().findById(choix);
		
	
		c.setPseudo("Dingo");
		c.setMail("Dingo@disney.com");
		c.setPassword("Do$$ar");
		c=Context.getInstance().getDaoCompte().update(c);
		
		
		
		Context.getInstance().closeEmf();
}
	/*public static void testDAOCompte(Compte objet, Integer id) {

		objet.setPassword("coco");
		objet= Context.getInstance().getDaoCompte().update(objet);
		
		Context.getInstance().getDaoCompte().findById(id);
		for(Compte c : Context.getInstance().getDaoCompte().findAll()) {
			System.out.println(c);
		}
		int choix= saisieInt("1:Delete by id\n2:delete by object");
		switch(choix) {
			case 1: Context.getInstance().getDaoCompte().deleteById(id);
				break;
			case 2: Context.getInstance().getDaoCompte().delete(objet);
				break;
			default : System.out.println("Vous n'avez pas fait un bon choix");
			break;
		}
		
	}*/
}
