package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOLivre;
import model.Livre;

public class DAOLivreJPA implements IDAOLivre{


	@Override
	public Livre findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Livre b = em.find(Livre.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Livre> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Livre",Livre.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Livre objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Livre update(Livre objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Livre objet) {
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
		Livre d=em.find(Livre.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}
