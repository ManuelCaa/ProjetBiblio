package test;

import java.util.Scanner;

import config.Context;
import model.Admin;
import model.Album;
import model.Bibliotheque;
import model.Utilisateur;

public class TestDAOHajar {
	
	public static int saisieInt(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static void remplissageBase() {
		Bibliotheque b =new Bibliotheque();

		Bibliotheque hajar =new Bibliotheque();

		 Admin a = new Admin("admin@gmail,com","123456","admin",b);
		Admin a1=new Admin("admin1@gmail.com","toto","admin1",hajar);

		Utilisateur u1 = new Utilisateur("hajar@gmail.com", "1234567", "hajars", hajar);
		Utilisateur u2 = new Utilisateur("toto@gmail.com", "totol", "u2", b);
		
		a=Context.getInstance().getDaoAdmin().update(a);
		
		Context.getInstance().getDaoAdmin().insert(a1);
		
		a.setMail("admin2@gmail.com");
		a=Context.getInstance().getDaoAdmin().update(a);
	}
	public static void testDAOAdmin(Admin objet, Integer id) {

		objet.setPassword("coco");
		objet= Context.getInstance().getDaoAdmin().update(objet);
		
		Context.getInstance().getDaoAdmin().findById(id);
		for(Admin a : Context.getInstance().getDaoAdmin().findAll()) {
			System.out.println("Admin id:"+a.getId()+"\nMail: "+a.getMail()+"\nPassword: "+a.getPassword()+"\nPseudo: "+a.getPseudo());
		}
		int choix= saisieInt("1:Delete by id\n2:delete by object");
		switch(choix) {
			case 1: Context.getInstance().getDaoAdmin().deleteById(id);
				break;
			case 2: Context.getInstance().getDaoAdmin().delete(objet);
				break;
			default : System.out.println("Vous n'avez pas fait un bon choix");
			break;
		}
		
	}
	public static void testDAOAlbum(Album objet, Integer id) {

		Context.getInstance().getDaoAlbum().update(objet);
		Context.getInstance().getDaoAlbum().findById(id);
		for(Album a : Context.getInstance().getDaoAlbum().findAll()) {
			System.out.println("Album [id=" + a.getId()+ ", type=" + a.getType()+ ", nombreMorceaux=" + a.getNombreMorceaux() + ", artiste=" + a.getArtiste()+"]");
		}
		int choix= saisieInt("1:Delete by id\n2:delete by object");
		switch(choix) {
			case 1: Context.getInstance().getDaoAlbum().deleteById(id);
				break;
			case 2: Context.getInstance().getDaoAlbum().delete(objet);
				break;
			default : System.out.println("Vous n'avez pas fait un bon choix");
			break;
		}
	}
	public static void testDAOBibliotheque(Bibliotheque objet, Integer id) {

		Context.getInstance().getDaoBibliotheque().update(objet);
		Context.getInstance().getDaoBibliotheque().findById(id);
		for(Bibliotheque b : Context.getInstance().getDaoBibliotheque().findAll()) {
			System.out.println("Bibliotheque [id=" + b.getId() + ", nom=" + b.getNom()+ ", visibilite=" + b.getVisibilite()+", fiches=" + b.getFiches() +"]");
		}
		int choix= saisieInt("1:Delete by id\n2:delete by object");
		switch(choix) {
			case 1: Context.getInstance().getDaoBibliotheque().deleteById(id);
				break;
			case 2: Context.getInstance().getDaoBibliotheque().delete(objet);
				break;
			default : System.out.println("Vous n'avez pas fait un bon choix");
			break;
		}
		
	}
}
