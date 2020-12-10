package test;

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

public class TestJPA {
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