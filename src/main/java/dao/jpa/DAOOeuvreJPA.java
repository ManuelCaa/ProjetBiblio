package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOOeuvre;
import model.Oeuvre;

public class DAOOeuvreJPA implements IDAOOeuvre {

	@Override
	public Oeuvre findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Oeuvre b = em.find(Oeuvre.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Oeuvre> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Oeuvre",Oeuvre.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Oeuvre objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Oeuvre update(Oeuvre objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Oeuvre objet) {
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
		Oeuvre d=em.find(Oeuvre.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}




