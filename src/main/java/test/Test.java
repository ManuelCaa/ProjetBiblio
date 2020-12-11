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
import model.*;


public class Test {
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
	static Compte connected=null;
	private static void menuAcceuil() {

		int choix = saisieInt("Application Bibliotheque\n1: Se connecter\n2: Créer un Compte");
		switch(choix) {
		case 1:
			String pseudo= saisieString("Pseudo:");
			String password=saisieString("Password:");

			connected=DAOCompteJPA.checkConnect(pseudo,password); 
			System.out.println(connected);

			if(connected instanceof Utilisateur) 
			{
				//menuUtilisateur();
				System.out.println("User");
			}
			else if(connected instanceof Admin) 
			{
				//menuAdmin();
				showBiblio();
				System.out.println("Admin");
			}
			else 
			{
				System.out.println("Mauvais identifiants");
				menuAcceuil();
			}
			break;
		case 2:	creacompte();
		break;
		default: 
			System.out.println("Mauvais choix");
			menuAcceuil();
			break;
		}

	}
	private static void creacompte() {

		int choix = saisieInt("1 : Administrateur\n"
				+ "2 : Utilisateur");
		switch(choix) {
		case 1:
			Admin anew=new Admin();
			Bibliotheque bnew= new Bibliotheque();
			String pseudo=saisieString("Entrer un pseudo");
			String pass=saisieString("Entrer un password");
			String mail=saisieString("Entrer votre mail");

			String nom=saisieString("Entrer un nom pour votre biblio");

			
			anew.setPseudo(pseudo);
			anew.setMail(pass);
			anew.setPassword(mail);
			bnew.setNom(nom);
			bnew.setCompte(anew);
			Context.getInstance().getDaoBibliotheque().insert(bnew);
			
			anew.setBiblio(bnew);
			Context.getInstance().getDaoAdmin().insert(anew);
		
			bnew.setCompte(anew);
			break;
		case 2:
			Utilisateur unew=new Utilisateur();
			Bibliotheque bnewu= new Bibliotheque();
			String pseudou=saisieString("Entrer un pseudo");
			String passu=saisieString("Entrer un password");
			String mailu=saisieString("Entrer votre mail");

			String nomu=saisieString("Entrer un nom pour votre biblio");
			
			
			unew.setPseudo(pseudou);
			unew.setMail(passu);
			unew.setPassword(mailu);
			bnewu.setNom(nomu);
		

			Context.getInstance().getDaoBibliotheque().insert(bnewu);
			bnewu.setCompte(unew);
			unew.setBiblio(bnewu);
			Context.getInstance().getDaoUtilisateur().insert(unew);break;
		}
		menuAcceuil();
	}
	
	private static void showBiblio() {
		System.out.println("Votre biblio");
		Bibliotheque b =Context.getInstance().getDaoBibliotheque().selectByIdCompte(connected.getId());
		

			System.out.println(b.getFiches());
		}

private static void showOeuvre() {
	
	System.out.println("les Oeuvres");
	/*	Oeuvre o=DAOOeuvreJPA.findAll();
		
		Oeuvre o=Context.getInstance().getDaoOeuvre().findAll();
		System.out.println(o);*/
		for(Oeuvre o : Context.getInstance().getDaoOeuvre().findAll()) {
			System.out.println(o);
		}
	}

private static void addOeuvreB() {
		//showOeuvre();

		int choix=saisieInt("Choisir une oeuvre pour votre biblio (id)");

		Oeuvre e= Context.getInstance().getDaoOeuvre().findById(choix);
		Bibliotheque b =Context.getInstance().getDaoBibliotheque().selectByIdCompte(connected.getId());

		Fiche f = new Fiche(0, null, 0, null, 0, null, null, e, b);

		Context.getInstance().getDaoFiche().insert(f);
	}

	/*private static void deleteOeuvreB() {
		for(Fiche f : Context.getInstance().getDaoBibliotheque().findById(connected.getBiblio().getId()).getFiches()) {
			System.out.println(f);
		}
		int choix=saisieInt("Choisir une oeuvre dans votre biblio � supprimer");
		Context.getInstance().getDaoBibliotheque().delete(choix);

	}

	private static void updateOeuvreFiche() {
		for(Fiche fi : Context.getInstance().getDaoFiche().findAll()) {
			System.out.println(fi);

			int choix=saisieInt("Choisir une Fiche");
			Fiche f = Context.getInstance().getDaoFiche().findById(choix);
			if(f==null) {System.out.println("Aucune Fiche avec ce numero");}
			else 
			{
				int note=saisieInt("Mettre une note /10");
				String pret=saisieString("Saisir le nom ou le pseudo � qui vous l'avez pret�");
				Integer lu = (saisieString("Avez vous Vu cette oeuvre ? (Y/N)").equalsIgnoreCase("Y"))? saisieInt("Combien de fois?") : null;
				String avis=saisieString("Saisir votre avis (bien, top, nul, bouse, moyen");
				Double duree=saisieDouble("Saisir la dur�e(jour)");

				f.setNote(note);
				f.setPretee(pret);
				f.setLu(lu);
				f.setAvis(avis);
				f.setDuree(duree);

				Context.getInstance().getDaoFiche().update(f);
			}}}*/
	public static void main(String[] args) {
		Context.getInstance();

		menuAcceuil();

		//creacompte();

		showBiblio();
		//showOeuvre();
		
		//addOeuvreB();

		Context.getInstance().closeEmf();
	}
}


