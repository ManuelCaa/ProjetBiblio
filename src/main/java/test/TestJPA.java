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
		
			Bibliotheque b1 =new Bibliotheque();			
			Bibliotheque b2 =new Bibliotheque();

			Admin a = new Admin("admin@gmail,com","123456","admin",b1);
			Admin a1=new Admin("admin1@gmail.com","toto","admin1",b2);
			
			Utilisateur u1 = new Utilisateur("hajar@gmail.com", "1234567", "hajars", b1);
			Utilisateur u2 = new Utilisateur("toto@gmail.com", "totol", "u2", b2);
			
			Oeuvre o1=new Oeuvre("Harry Potter et la coupe de feu","quatrieme annee au college de Poudlard","HPCF",
					2000,"Gallimard",LocalDate.parse("11-05-2018"), LocalDate.parse("12-04-2019"),true);
			
			Oeuvre o2=new Oeuvre("Harry Potter e l'ecole des sorciers","premiere annee au college de Poudlard","HPES",
					1998,"Gallimard",LocalDate.parse("25-08-2012"),LocalDate.parse("12-04-2019"),true);
			
			Album al1 = new Album("Album1","album1 sur scene","FIAL1",2005, "Universal",LocalDate.parse("26-08-2014"),LocalDate.parse("25-04-2018"),true,12,"M");
			Album al2 = new Album("Album2","album2 compil","FIAL2",2007,"Universal",LocalDate.parse("26-12-2017"),LocalDate.parse("05-06-2019"),true,14,"Goya");
			
			Livre l1=new Livre("Harry Potter a l'ecole des sorciers","premiere annee au college de Poudlard","HPES",
					1998,"Gallimard",LocalDate.parse("25-08-2012"),LocalDate.parse("12-04-2019"),true,15,"Rowling");
			
			Livre l2= new Livre("Harry Potter et le prisionner d'Azkaban","troisieme annee au college de Poudlard","HPPA",
					1999,"Gallimard",LocalDate.parse("19-08-2014"),LocalDate.parse("12-04-2019"),true,18,"Rowling");
			
			
			Context.getInstance().getDaoAdmin().insert(a);
			Context.getInstance().getDaoAdmin().insert(a1);
			Context.getInstance().getDaoUtilisateur().insert(u1);
			Context.getInstance().getDaoUtilisateur().insert(u1);
			Context.getInstance().getDaoBibliotheque().insert(b1);
			Context.getInstance().getDaoBibliotheque().insert(b2);
			Context.getInstance().getDaoOeuvre().insert(o1);
			Context.getInstance().getDaoOeuvre().insert(o2);
			Context.getInstance().getDaoAlbum().insert(al1);
			Context.getInstance().getDaoAlbum().insert(al2);
			Context.getInstance().getDaoLivre().insert(l1);
			Context.getInstance().getDaoLivre().insert(l2);
			
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
		
		
		Context.getInstance().closeEmf();
	}
}