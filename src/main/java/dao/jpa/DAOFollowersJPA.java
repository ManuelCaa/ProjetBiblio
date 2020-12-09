package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOFollowers;
import model.Followers;

public class DAOFollowersJPA implements IDAOFollowers{


	@Override
	public Followers findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Followers b = em.find(Followers.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Followers> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Followers",Followers.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Followers objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Followers update(Followers objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Followers objet) {
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
		Followers d=em.find(Followers.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}
