package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOUtilisateur;
import model.Utilisateur;

public class DAOUtilisateurJPA implements IDAOUtilisateur{


	@Override
	public Utilisateur findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Utilisateur b = em.find(Utilisateur.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Utilisateur> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Utilisateur",Utilisateur.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Utilisateur objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Utilisateur update(Utilisateur objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Utilisateur objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);

		em.remove(objet);

		em.getTransaction().commit();
		em.close();
	}
	@Override
	public void deleteById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Utilisateur d=em.find(Utilisateur.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}

}
