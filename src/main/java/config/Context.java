package config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOAdmin;
import dao.IDAOAlbum;
import dao.IDAOBibliotheque;
import dao.IDAOCompte;
import dao.IDAOFiche;
import dao.IDAOFollowers;
import dao.IDAOFollowing;
import dao.IDAOLivre;
import dao.IDAOOeuvre;
import dao.IDAOUtilisateur;
import dao.jpa.DAOAdminJPA;
import dao.jpa.DAOAlbumJPA;
import dao.jpa.DAOBibliothequeJPA;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOFicheJPA;
import dao.jpa.DAOFollowersJPA;
import dao.jpa.DAOFollowingJPA;
import dao.jpa.DAOLivreJPA;
import dao.jpa.DAOOeuvreJPA;
import dao.jpa.DAOUtilisateurJPA;
public class Context {
	
	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");


	private IDAOAlbum daoAlbum= new DAOAlbumJPA();
	private IDAOBibliotheque daoBibliotheque = new DAOBibliothequeJPA();
	private IDAOFiche daoFiche = new DAOFicheJPA();
	private IDAOLivre daoLivre = new DAOLivreJPA();
	private IDAOOeuvre daoOeuvre = new DAOOeuvreJPA();
	private IDAOFollowers daoFollowers= new DAOFollowersJPA();
	private IDAOFollowing daoFollowing = new DAOFollowingJPA();
	private IDAOUtilisateur daoUtilisateur = new DAOUtilisateurJPA();
	private IDAOAdmin daoAdmin = new DAOAdminJPA();
	private IDAOCompte daoCompte = new DAOCompteJPA();
	private Context() {}
	
	public static Context getInstance()
	{
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}


	public IDAOAlbum getDaoAlbum() {
		return daoAlbum;
	}

	public IDAOBibliotheque getDaoBibliotheque() {
		return daoBibliotheque;
	}

	public IDAOFiche getDaoFiche() {
		return daoFiche;
	}

	public IDAOLivre getDaoLivre() {
		return daoLivre;
	}

	public IDAOOeuvre getDaoOeuvre() {
		return daoOeuvre;
	}


	public IDAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	public IDAOAdmin getDaoAdmin() {
		return daoAdmin;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IDAOFollowers getDaoFollowers() {
		return daoFollowers;
	}

	public IDAOFollowing getDaoFollowing() {
		return daoFollowing;
	}


	
}
