package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOFollowing;
import model.Following;

public class DAOFollowingJPA implements IDAOFollowing{

	@Override
	public Following findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Following b = em.find(Following.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Following> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Following",Following.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Following objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Following update(Following objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Following objet) {
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
		Following d=em.find(Following.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}
