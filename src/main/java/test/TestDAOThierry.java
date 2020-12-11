package test;

import config.Context;
import dao.jpa.DAOOeuvreJPA;
import dao.jpa.DAOSuiviJPA;
import model.Bibliotheque;
import model.Oeuvre;
import model.Suivi;
import model.Utilisateur;

public class TestDAOThierry {
	//Menu gestionBase() repris de Testbiblio
/*	private static void gestionBaseD() {
		System.out.println("Gestion base ");
		System.out.println("Choix du menu :");
		//System.out.println("1 - Valider une Oeuvre");
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
		//case 5:menuAdmin();break;
		//case 5 modifié pour le test:
		case 5:System.out.println("sortie du menu OK"); System.exit(0);break;
		}
		gestionBaseD();
	}*/
	/////////////////////////////////////////
	
	/*public static void testDAOOeuvre()
	{
		DAOOeuvreJPA daoOeuvre = new DAOOeuvreJPA();
		
		System.out.println("2 - Ajoute oeuvreo1 et o2 (insert)");
		Oeuvre o1=new Oeuvre();
		Context.getInstance().getDaoOeuvre().insert(o1);
		Oeuvre o2=new Oeuvre();
		Context.getInstance().getDaoOeuvre().insert(o2);
		System.out.println("2 oeuvres ajoutees");
		System.out.println(o1);
		System.out.println(o2);
		
		System.out.println("liste des oeuvres");
		Context.getInstance().getDaoOeuvre().findAll();
		
		System.out.println("selection oeuvre id=1");
		Context.getInstance().getDaoOeuvre().findById(1);
		
		System.out.println("3 - Suppression oeuvre o2 (delete)");
		Context.getInstance().getDaoOeuvre().delete(o2);
		System.out.println("1 oeuvre supprimée");
		System.out.println("liste des oeuvres");
		Context.getInstance().getDaoOeuvre().findAll();
		
		System.out.println("4 - modification oeuvre o1 (update)");
		Context.getInstance().getDaoOeuvre().update(o1);
		
		Context.getInstance().closeEmf();
	}*/
	
	public static void testDAOSuivi()
	{
		DAOSuiviJPA daoSuivi = new DAOSuiviJPA();
		
		Bibliotheque b1 =new Bibliotheque();
		Context.getInstance().getDaoBibliotheque().insert(b1);
		Utilisateur u1 = new Utilisateur("hajar@gmail.com", "1234567", "hajars", b1);
		Context.getInstance().getDaoUtilisateur().insert(u1);
		
		System.out.println("1 - Ajout Suivi s1, s2, s3 (insert)");
		Suivi s1=new Suivi();
		s1.setId(1);
		Context.getInstance().getDaoSuivi().insert(s1);
		Suivi s2=new Suivi();
		s2.setId(2);
		Context.getInstance().getDaoSuivi().insert(s2);
		Suivi s3=new Suivi();
		s3.setId(3);
		Context.getInstance().getDaoSuivi().insert(s3);
		
		System.out.println("2 - liste des Suivis (id)");
		for(Suivi s :Context.getInstance().getDaoSuivi().findAll())
		{
			//System.out.println("id = "+s.getId()+", follower = "+s.getFollower().toString()+", folowing = "+s.getFollowing().toString());
			System.out.println("id = "+s.getId());
		}
		
		System.out.println("3 - selection Suivi id=1");
		Suivi s=Context.getInstance().getDaoSuivi().findById(1);
		//System.out.println("id = "+s.getId()+", follower = "+s.getFollower()+", following = "+s.getFollowing());
		System.out.println("id = "+s.getId());
		
		System.out.println("4 - Suppression Suivi s3 (delete)");
		Context.getInstance().getDaoSuivi().delete(s3);
		//System.out.println(" Suivi s3 supprimé");
		System.out.println("liste des Suivis");
		for(Suivi x :Context.getInstance().getDaoSuivi().findAll())
		{
			//System.out.println("id = "+x.getId()+", follower = "+x.getFollower()+", following = "+x.getFollowing());
			System.out.println("id = "+x.getId());
		}
		
		System.out.println("4 - modification Suivi s2 (update)");
		s2.setFollower(u1);
		Context.getInstance().getDaoSuivi().update(s2);
		//System.out.println("id = "+s2.getId()+", follower = "+s2.getFollower()+", following = "+s2.getFollowing());
		System.out.println("id = "+s2.getId()+"pseudo follower ajoute = "+s2.getFollower().getPseudo());
		Context.getInstance().closeEmf();
	}
public static void main(String[] args) 
{
	//testDAOOeuvre();
	testDAOSuivi();
}

}
