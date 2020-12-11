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
	
	static Compte connected=null;

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
			
			/*Oeuvre o1=new Oeuvre("Harry Potter et la coupe de feu","quatrieme annee au college de Poudlard","HPCF",
					2000,"Gallimard",LocalDate.parse("2018-11-05"), LocalDate.parse("2019-12-04"),true);
			
			Oeuvre o2=new Oeuvre("Harry Potter e l'ecole des sorciers","premiere annee au college de Poudlard","HPES",
					1998,"Gallimard",LocalDate.parse("2012-05-08"),LocalDate.parse("2019-12-04"),true);*/
			
			Album al1 = new Album("Album1","album1 sur scene","FIAL1",2005, "Universal",LocalDate.parse("2014-08-08"),LocalDate.parse("2018-05-04"),true,12,"M");
			Album al2 = new Album("Album2","album2 compil","FIAL2",2007,"Universal",LocalDate.parse("2017-06-12"),LocalDate.parse("2019-05-06"),true,14,"Goya");
			
			Livre l1=new Livre("Harry Potter a l'ecole des sorciers","premiere annee au college de Poudlard","HPES",
					1998,"Gallimard",LocalDate.parse("2012-05-08"),LocalDate.parse("2019-12-04"),true,15,"Rowling");
			
			Livre l2= new Livre("Harry Potter et le prisionner d'Azkaban","troisieme annee au college de Poudlard","HPPA",
					1999,"Gallimard",LocalDate.parse("2014-09-08"),LocalDate.parse("2019-12-04"),true,18,"Rowling");
			
			Context.getInstance().getDaoBibliotheque().insert(b1);
			Context.getInstance().getDaoBibliotheque().insert(b2);
			Context.getInstance().getDaoAdmin().insert(a);
			Context.getInstance().getDaoAdmin().insert(a1);
			Context.getInstance().getDaoUtilisateur().insert(u1);
			Context.getInstance().getDaoUtilisateur().insert(u2);
			
			
			Context.getInstance().getDaoAlbum().insert(al1);
			Context.getInstance().getDaoAlbum().insert(al2);
			Context.getInstance().getDaoLivre().insert(l1);
			Context.getInstance().getDaoLivre().insert(l2);
			
			//Context.getInstance().getDaoAdmin().update(a).setMail("admin2@gmail.com");
		
	}
	
	private static void menuAcceuil() {
		
			int choix = saisieInt("Application Bibliotheque : \n1 - Se connecter \n2 - Créer un Compte ");
			switch(choix) {
				case 1:
					String pseudo= saisieString("Pseudo:");
					String password=saisieString("Password:");
					connected=Compte.checkConnect(pseudo,password); //faire la fonction checkConnect
					if(connected instanceof Utilisateur) 
					{
						//menuUtilisateur();
					}
					else if(connected instanceof Admin) 
					{
						//menuAdmin();
					}
					else 
					{
						System.out.println("Mauvais identifiants");
						menuAcceuil();
					}
					break;
				case 2:	//demande s'il veut creer un compte admin ou utilisateur
					break;
				default: 
						System.out.println("Mauvais choix");
						menuAcceuil();
						break;
			}
		
		}

	private static void menuAdmin() {
			System.out.println("Bienvenue dans le menu Admin");
			System.out.println("Choix du menu :");
			int choix = saisieInt("1: Parametres du compte\n2: Voir les Bibliotheque existantes\n3: Voir ma bibliotheque\n4 - Gestion de ma bibliotheque\n5 - Se Deconnecter");
			switch(choix) 
			{
				case 1: gestionCompte(); break; 
				case 2: voirBibliotheques();break;
				case 3: voirMaBibliotheque();break;
				case 4: gestionMaBibliotheque();break;
				case 5 : System.exit(0);break;
				default : menuAdmin(); break;
			}
			menuAdmin();
	}
	private static void gestionCompte() {
		System.out.println("Compte [id=" + connected.getId() + ", mail=" + connected.getMail() + ", password=" + connected.getPassword() + ", pseudo=" + connected.getPseudo() + ", biblio="
				+ connected.getBiblio() + ", followers=" + connected.getFollowers() + ", followings=" + connected.getFollowing() + "]");
	
		int choix= saisieInt("\n1 - Changer le password\n2 - Changer le pseudo \n3 - Supprimer un follower\n4 - Demande des abonnements (followers)\n5 - Supprimer un abonnement\n6 - quitter\n7 - Se deconnecter");
		switch(choix)
		{
		case 1 : break; 
		case 2 : break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		case 6 : gestionCompte();break;
		case 7 : System.exit(0);break;
		default : menuAdmin(); break;
	}
	gestionCompte();
	}
	private static void voirBibliotheques() {
		for(Bibliotheque b : Context.getInstance().getDaoBibliotheque().findAll()) {
			System.out.println("Bibliotheque [id=" + b.getId() + ", nom=" + b.getNom()+ ", visibilite=" + b.getVisibilite()+", fiches=" + b.getFiches() +"]");
		}
		int choix = saisieInt("1: Suivre un compte\n2: quitter \n3 - Se Deconnecter");
		switch(choix) 
		{
			case 1: int id= saisieInt("Id de la bibliotheque du compte");
					Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(id);
					Suivi s1,s2;
					if(b.getVisibilite().equals(Visibilite.Public)) {
						 s1 = new Suivi(true, (Utilisateur)connected, (Utilisateur)b.getCompte());
						 s2= new Suivi(true, (Utilisateur)b.getCompte(), (Utilisateur)connected);
					}else {
						 s1 = new Suivi(false, (Utilisateur)connected, (Utilisateur)b.getCompte());
						 s2= new Suivi(false, (Utilisateur)b.getCompte(), (Utilisateur)connected);
					}

					connected.getFollowing().add(s1);
					b.getCompte().getFollowers().add(s2);
				  break;
			case 2 : menuAdmin();break;
			case 3 : System.exit(0);break;
			default : voirBibliotheques(); break;
		}
		voirBibliotheques();
	}

	private static void voirMaBibliotheque() {
		System.out.println("Visualisation de ma bibliotheque");
		System.out.println("choix de menu:");
		int choix  = saisieInt("1: Parametres de ma bibliotheque\n2 - quitter\n3 - Se Deconnecter");
		switch(choix) 
		{
			case 1: 
				Bibliotheque b = connected.getBiblio();
				System.out.println("Bibliotheque [id=" + b.getId() + ", nom=" + b.getNom()+ ", visibilite=" + b.getVisibilite()+", fiches=" + b.getFiches() +"]");
				break;
			case 2 : menuAdmin();break;
			case 3 : System.exit(0);break;
			default : voirMaBibliotheque(); break;
		}
		voirMaBibliotheque() ;
	}
	
	private static void gestionMaBibliotheque() {

		System.out.println("Gestion de ma bibliotheque");
		System.out.println("choix de menu:");
		int choix  = saisieInt("1: Parametres de ma bibliotheque\n2 - Parametres de mon compte\n3- La liste de mes abonnes\n3 - La liste de mes abonnements\n quitter\n3 - Se Deconnecter");
		
		gestionMaBibliotheque();
		
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
		
		System.out.println(daoOeuvre.findAll());
		
		remplissageBase();
		

		
		Context.getInstance().closeEmf();
	}
}