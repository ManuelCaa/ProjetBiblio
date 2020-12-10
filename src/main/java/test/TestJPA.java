package test;

import java.time.LocalDate;
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
import model.Bibliotheque;

public class TestJPA {
	
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
		
		Bibliotheque b =new Bibliotheque();
		
		Bibliotheque hajar =new Bibliotheque();

		Admin a = new Admin("admin@gmail,com","123456","admin",b);
		Admin a1=new Admin("admin1@gmail.com","toto","admin1",hajar);
		
		Context.getInstance().getDaoAdmin().insert(a);
		Context.getInstance().getDaoAdmin().insert(a1);
		
		for(Admin ad : Context.getInstance().getDaoAdmin().findAll()) 
		{
			System.out.println(ad.getMail()+" "+ad.getPassword()+" "+ad.getPseudo());
		}
		
		Context.getInstance().getDaoAdmin().update(a).setMail("admin2@gmail.com");
		
		Context.getInstance().closeEmf();
}
}