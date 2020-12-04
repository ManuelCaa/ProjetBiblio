package config;

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
import dao.jdbc.DAOAdminJDBC;
import dao.jdbc.DAOAlbumJDBC;
import dao.jdbc.DAOBibliothequeJDBC;
import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOFicheJDBC;
import dao.jdbc.DAOFollowersJDBC;
import dao.jdbc.DAOFollowingJDBC;
import dao.jdbc.DAOLivreJDBC;
import dao.jdbc.DAOOeuvreJDBC;
import dao.jdbc.DAOUtilisateurJDBC;
public class Context {
	
	private static Context _instance;


	private IDAOAlbum daoAlbum= new DAOAlbumJDBC();
	private IDAOBibliotheque daoBibliotheque = new DAOBibliothequeJDBC();
	private IDAOFiche daoFiche = new DAOFicheJDBC();
	private IDAOLivre daoLivre = new DAOLivreJDBC();
	private IDAOOeuvre daoOeuvre = new DAOOeuvreJDBC();
	private IDAOFollowers daoFollowers= new DAOFollowersJDBC();
	private IDAOFollowing daoFollowing = new DAOFollowingJDBC();
	private IDAOUtilisateur daoUtilisateur = new DAOUtilisateurJDBC();
	private IDAOAdmin daoAdmin = new DAOAdminJDBC();
	private IDAOCompte daoCompte = new DAOCompteJDBC();
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


	
}
