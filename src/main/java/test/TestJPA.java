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
import model.*;

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
	public static void remplissageBase() {
			Bibliotheque b =new Bibliotheque();
			
			Bibliotheque hajar =new Bibliotheque();

			Admin a = new Admin("admin@gmail,com","123456","admin",b);
			Admin a1=new Admin("admin1@gmail.com","toto","admin1",hajar);
			
			Utilisateur u1 = new Utilisateur("hajar@gmail.com", "1234567", "hajars", hajar);
			Utilisateur u2 = new Utilisateur("toto@gmail.com", "totol", "u2", b);
			
			Context.getInstance().getDaoAdmin().insert(a);
			Context.getInstance().getDaoAdmin().insert(a1);
			
			Context.getInstance().getDaoAdmin().update(a).setMail("admin2@gmail.com");
		
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
		remplissageBase();
		
		Context.getInstance().closeEmf();
}
}