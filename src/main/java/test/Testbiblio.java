package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.protobuf.StringValue;

import config.Context;
import dao.jpa.DAOCompteJPA;
import model.*;

public class Testbiblio {

	public static List<Compte> comptes=new ArrayList<Compte>();

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
					1998,"Gallimard",LocalDate.parse("2012-05-08"),LocalDate.parse("2019-12-04"),true);
		 */
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


	static Compte connected=null;

	private static void menuAcceuil() {
		System.out.println("------------------------------------------------");
		int choix = saisieInt("Application Bibliotheque\n1: Se connecter\n2: Créer un Compte");
		switch(choix) {
		case 1:
			String pseudo= saisieString("Pseudo:");
			String password=saisieString("Password:");
			try{

				connected=DAOCompteJPA.checkConnect(pseudo,password); 
				System.out.println(connected);
			}catch(Exception e) {
				System.out.println("Mauvais identifiants");
			}

			if(connected instanceof Utilisateur) 
			{
				menuUtilisateur();

			}
			else if(connected instanceof Admin) 
			{
				menuAdmin();

			}
			else 
			{
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
		System.out.println("------------------------------------------------");
		int choix = saisieInt("1 : Administrateur\n"
				+ "2 : Utilisateur");
		switch(choix) {
		case 1:
			Admin anew=new Admin();
			Bibliotheque bnew= new Bibliotheque();
			String pseudo=saisieString("Entrer un pseudo");
			String pass=saisieString("Entrer un password");
			String mail=saisieString("Entrer votre mail");

			//String nom=saisieString("Entrer un nom pour votre biblio");


			anew.setPseudo(pseudo);
			anew.setMail(mail);
			anew.setPassword(pass);
			//bnew.setNom(nom);
			Context.getInstance().getDaoBibliotheque().insert(bnew);

			//anew.setBiblio(bnew);
			Context.getInstance().getDaoAdmin().insert(anew);break;

		case 2:
			Utilisateur unew=new Utilisateur();
			Bibliotheque bnewu= new Bibliotheque();
			String pseudou=saisieString("Entrer un pseudo");
			String passu=saisieString("Entrer un password");
			String mailu=saisieString("Entrer votre mail");

			String nomu=saisieString("Entrer un nom pour votre biblio");


			unew.setPseudo(pseudou);
			unew.setMail(mailu);
			unew.setPassword(passu);
			bnewu.setNom(nomu);

			Context.getInstance().getDaoBibliotheque().insert(bnewu);
			unew.setBiblio(bnewu);
			Context.getInstance().getDaoUtilisateur().insert(unew);break;
		}
		menuAcceuil();
	}


	private static void menuAdmin() {
		System.out.println("------------------------------------------------");
		if(connected.getBiblio()==null) {

			System.out.println("Bienvenue dans le menu Admin");
			System.out.println("Vous n'avez pas encore une bibliotheque");
			System.out.println("1 - Creer une bibliotheque");
			System.out.println("2 - Gestion de mon compte");
			System.out.println("3 - Me deconnecter");
			int choix2 = saisieInt("");
			switch(choix2) {
			case 1 : creeBiblio();break;
			case 2 : break;
			case 3 : System.exit(0); break;
			}
		} else {

			System.out.println("Bienvenue dans le menu Admin");
			System.out.println("Choix du menu :");
			System.out.println("1 - Voir ma bibliotheque");
			System.out.println("2 - Gestion de ma bibliotheque");
			System.out.println("3 - Gerer la base de donnees de l'application");//ajout ou supprime une oeuvre
			System.out.println("4 - Voir toutes les oeuvres");
			System.out.println("5 - Gestion ma liste Following");
			System.out.println("6 - Gestion ma liste Followers");
			System.out.println("7 - Deconnect");
			int choix = saisieInt("");
			switch(choix) 
			{
			case 1:showBiblio(connected.getBiblio());break;
			case 2:gestionMabiblio();break;
			case 3:gestionBaseD();break;
			case 4:showOeuvre();break;
			case 5:gestionFollowing();break;
			case 6:gestionFollowers();break;
			case 7:System.exit(0);break;
			}
		}
		menuAdmin();
	}

	private static void gestionBaseD() {
		System.out.println("Gestion base ");
		System.out.println("Choix du menu :");
		System.out.println("1 - Valider une Oeuvre");
		System.out.println("2 - Ajouter une Oeuvre");
		System.out.println("3 - Supprimer une oeuvre");
		System.out.println("4 - Modifier une  Oeuvre");
		System.out.println("5 - Retour menu");
		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:validOeuvre();break;
		case 2:addOeuvre();break;
		case 3:deleteOeuvre();break;
		case 4:updateOeuvre();break;
		case 5:menuAdmin();break;
		}

		gestionBaseD();

	}
	private static void gestionFollowing(){
		System.out.println("Gestion Liste Following ");
		System.out.println("Choix du menu :");
		System.out.println("1 - Afficher la liste de following");
		System.out.println("2 - Supprimer un following");
		System.out.println("3 - Retour menu");
		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:for(Suivi u : connected.getFollowing()) {
			System.out.println(u.getFollower());
		};
		break;
		case 2: int id = saisieInt("id following a supprimer");
		Suivi s = connected.getFollowing().get(id);
		Context.getInstance().getDaoSuivi().delete(s);
		break;
		case 3:	if(connected instanceof Utilisateur) 
		{
			menuUtilisateur();

		}
		else if(connected instanceof Admin) 
		{
			menuAdmin();

		};break;
		}

		gestionFollowing();
	}
	private static void gestionFollowers(){
		System.out.println("Gestion Liste Followers ");
		System.out.println("Choix du menu :");
		System.out.println("1 - Afficher la liste de followers");
		System.out.println("2 - Supprimer un follower");
		System.out.println("3 - Afficher la liste des demandes de follow");
		System.out.println("4 - Retour menu");
		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:for(Suivi u : connected.getFollowers()) {
			if(u.isAccepte()==true) System.out.println(u.getFollowing());
		};
		break;
		case 2: int id = saisieInt("id follower a supprimer");
		Suivi s = connected.getFollowers().get(id);
		Context.getInstance().getDaoSuivi().delete(s);
		break;
		case 3 : demandeFollow(); break;
		case 4:	if(connected instanceof Utilisateur) 
		{
			menuUtilisateur();

		}
		else if(connected instanceof Admin) 
		{
			menuAdmin();

		};break;
		}

		gestionFollowers();
	}

	public static void demandeFollow() {
		for(Suivi s: connected.getFollowers()) {
			if(s.isAccepte()==false) {
				System.out.println(s);
				int choix = saisieInt("1: approuver cette demande\n2: Refuser cette demande\n");
				if(choix==1)  s.setAccepte(true);
				else  s.setAccepte(false);
			}
		}
	}
	private static void validOeuvre() {
		System.out.println("La liste des oeuvres qui ne sont pas encore validées");
		for(Oeuvre o : Context.getInstance().getDaoOeuvre().findAll()) {
			if(o.isModerationEffectuee()==false) System.out.println(o);
		}
		int choix = saisieInt("Choisir une oeuvre par son id");
		Oeuvre o= Context.getInstance().getDaoOeuvre().findById(choix);
		o.setModerationEffectuee(true);
	}

	private static void addOeuvre() {

		String titre=saisieString("Saisir le titre");
		String descriptif=saisieString("Saisir descriptif");
		String nomFichierImage=saisieString("Saisir image");
		int annee=saisieInt("Saisir l'annee de creation de l'oeuvre (yyyy)");
		String editeur=saisieString("Saisir l'editeur de l'oeuvre");
		LocalDate creeA=LocalDate.now();
		LocalDate modifieeA=LocalDate.now();
		boolean moderationEffectuee= true;

		Oeuvre o = new Oeuvre(titre, descriptif, nomFichierImage, annee, editeur, creeA,modifieeA,true);
		Context.getInstance().getDaoOeuvre().insert(o);

	}

	private static void deleteOeuvre() {
		for(Oeuvre o : Context.getInstance().getDaoOeuvre().findAll()) {
			System.out.println(o);
		}
		int choix=saisieInt("Choisir l'id de l'oeuvre a supprimer de la base de donnee");

		Context.getInstance().getDaoOeuvre().deleteById(choix);


	}

	private static void updateOeuvre() {
		showOeuvre();

		int choix=saisieInt("Choisir une Oeuvre (id)");
		Oeuvre o = Context.getInstance().getDaoOeuvre().findById(choix);
		if(o==null) {System.out.println("Aucune Oeuvre avec ce numero");}
		else{
			int choix2=saisieInt("1 - modifier le titre\n2 - modifier le descriptif\n3 - Modifier l'image\n4 - Modifier la date de creation\n5 - Modifier l'editeur");
			switch(choix2) {
			case 1 : String titre=saisieString("Saisir le titre");o.setTitre(titre); break;
			case 2 : String descriptif=saisieString("Saisir descriptif");o.setDescriptif(descriptif);break;
			case 3 :String nomFichierImage=saisieString("Saisir image");o.setNomFichierImage(nomFichierImage); break;
			case 4 : int annee=saisieInt("Saisir l'ann�e de creation de l'oeuvre (yyyy)");o.setAnnee(annee);break;
			case 5 :String editeur=saisieString("Saisir l'editeur de l'oeuvre");o.setEditeur(editeur);break;
			default: System.out.println("Vous n'avez pas fait un bon choix"); break;
			}
			LocalDate modifieeA=LocalDate.now();o.setModifieeA(modifieeA);
			Context.getInstance().getDaoOeuvre().update(o);
		}

	}
	private static void menuUtilisateur() {
		System.out.println("Bienvenue dans votre biblio");
		System.out.println("Choix du menu :");
		System.out.println("1 - Voir ma bibliotheque");
		System.out.println("2 - Gestion de ma bibliotheque");
		System.out.println("3 - Voir les oeuvres");
		System.out.println("4 - Mes amis");
		System.out.println("5 - Mes Followers");
		System.out.println("6 - Se Deconnecter");
		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:showBiblio(connected.getBiblio());break;
		case 2:gestionMabiblio();break;
		case 3:showOeuvre();break;
		case 4:gestionFollowing();break;
		case 5:gestionFollowers();break;
		case 6:System.exit(0);break;
		}

		menuUtilisateur();
	}


	private static void showBiblio(Bibliotheque b) {
		if(b!=null) {

			System.out.println("Votre biblio");
			System.out.println("Bibliotheque [id=" + b.getId() + ", nom=" + b.getNom() + ", compte=" + b.getCompte() + ", visibilite=" + b.getVisibilite()
			+ ", fiches=" + b.getFiches() +"]");

		}else {
			System.out.println("Vous n'avez pas encore cree une biblio");
		}
	}
	private static void creeBiblio() {
		String nom = saisieString("Nom de la bibliotheque");
		String v;
		v=saisieString("Visibilite: Public, Prive ou Followers");
		Bibliotheque b = new Bibliotheque(Visibilite.valueOf(v), nom);
		Context.getInstance().getDaoBibliotheque().insert(b);
	}
	private static void gestionMabiblio() {
		System.out.println("Gestion de votre biblio");
		System.out.println("Choix du menu :");
		System.out.println("1 - Ajouter une oeuvre a ma biblio");
		System.out.println("2 - Supprimer une oeuvre de ma biblio");
		System.out.println("3 - Modifier la fiche d'une oeuvre de ma biblio");
		System.out.println("4 - Proposer une oeuvre");
		System.out.println("5 - Retour menu");
		int choix = saisieInt("");
		switch(choix) 
		{

		case 1:addOeuvreB();break;
		case 2:deleteOeuvreB();break;
		case 3:updateOeuvreFiche();break;
		case 4:propoOeuvre();break;
		case 5:	if(connected instanceof Utilisateur) 
		{
			menuUtilisateur();

		}
		else if(connected instanceof Admin) 
		{
			menuAdmin();

		};break;
		}

		menuUtilisateur();

	}


	private static void showOeuvre() {
		for(Oeuvre o : Context.getInstance().getDaoOeuvre().findAll()) {
			if(o.isModerationEffectuee()==true) System.out.println(o);
		}
	}

	private static void addOeuvreB() {
		//showOeuvre();

		int choix=saisieInt("Choisir une oeuvre pour votre biblio (id)");

		Oeuvre e= Context.getInstance().getDaoOeuvre().findById(choix);
		Bibliotheque b =Context.getInstance().getDaoBibliotheque().selectByIdCompte(connected.getId());

		Fiche f = new Fiche();
		int note=saisieInt("Entrer une note");
		double duree=saisieInt("Entrer une duree");
		String pret=saisieString("Preter?");
		String avis=saisieString("Entrer votre avis");

		f.setAvis(avis);
		f.setDuree(duree);
		f.setNote(note);
		f.setPretee(pret);


		Context.getInstance().getDaoFiche().insert(f);
	}

	private static void deleteOeuvreB() {
		for(Fiche f : Context.getInstance().getDaoBibliotheque().findById(connected.getBiblio().getId()).getFiches()) {
			System.out.println(f);
		}
		int choix=saisieInt("Choisir une oeuvre dans votre biblio a supprimer");
		Context.getInstance().getDaoBibliotheque().deleteById(choix);

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
			}}}

	private static void propoOeuvre() {
		//a voir plus tard
	}
	/*
	private static void gestionMesAmis() {

		System.out.println("Gerer mes amis");

		for(Suivi s : Context.getInstance().getDAOSuivi().SelectAll()) {
			System.out.println(s);
		}

		System.out.println("Choix du menu :");
		System.out.println("1 - Ajouter un ami");
		System.out.println("2 - Supprimer un amis");
		System.out.println("3 - Selectionner la biblioth�que d'un ami");
		System.out.println("4 - oeuvre");
		System.out.println("5 - Retour");



		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:addAmis();break;
		case 2:deleteAmis();break;
		case 3:SelectAmis();break;
		case 4: if (connected instanceof Admin) { menuAdmin();} else {menu();}break;

		}
	}
	 */
	/*
	private static void addAmis() {
		String utilisateurSuivi=saisieString("Saisir le pseudo");
		// demande d'amis
		//Si Non => rien
		//Si OUI
		Suivi Amis= new Suivi(true, null, utilisateurSuivi);
		Context.getInstance().getDaoSuivi().ajouter(utilisateurSuivi);	}

	private static void deleteAmis() {
		for(Suivi s : Context.getInstance().getDAOSuiviJDBC().SelectAll()) {
			System.out.println(s);
		}
		int choix=saisieInt("Choisir un Amis � supprimer (id)");
		Context.getInstance().getDAOSuiviJDBC().supprimer(choix);
	}

	private static void SelectAmis() {
		for(Suivi s : Context.getInstance().getDAOSuiviJDBC().SelectAll().getName()) {
			System.out.println(s);
		}
		int choix= saisieInt("Saisir l'ami dont vous voulez voir la biblioth�que(id)");
		Context.getInstance().getDaoSuivi().SelectById(choix);	
	}

	private static void gestionFollowers() {
		System.out.println("Gerer mes Followers");

		for(Suivi s : Context.getInstance().getDAOSuiviJDBC().SelectAll()) {
			System.out.println(s);
		}

		System.out.println("Choix du menu :");
		System.out.println("1 - Valider un Follower");
		System.out.println("2 - Supprimer un Follower");
		System.out.println("4 - Retour");

		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:validFoll();break;
		case 2:deleteFoll();break;
		case 3: if (connected instanceof Admin) { menuAdmin();} else {menu();}break;

		}
	}

	private static void validFoll(String pseudo) {

		boolean  = (saisieString("Voulez vous etre suivi par "+pseudo+ "? (Y/N)").equals("Y"))?
				Context.getInstance().getDaoSuivi().ajouter(valid) : null;



	}
	private static void deleteFoll() {
		for(Suivi s : Context.getInstance().getDAOSuiviJDBC().SelectAll()) {
			System.out.println(s);
		}
		int choix=saisieInt("Choisir un Follower � supprimer (id)");
		Context.getInstance().getDAOSuiviJDBC().supprimer(choix);

	}*/

	public static void main(String[] args) {
		remplissageBase();
		Context.getInstance();
		menuAcceuil();

		Context.getInstance().closeEmf();
	}
}
