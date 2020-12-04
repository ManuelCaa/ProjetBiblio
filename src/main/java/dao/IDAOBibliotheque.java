package dao;

import model.Bibliotheque;

public interface IDAOBibliotheque extends IDAO<Bibliotheque,Integer>{

	
	public Bibliotheque selectByIdCompte(Integer id);
}
