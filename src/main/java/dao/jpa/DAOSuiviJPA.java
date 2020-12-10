package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOSuivi;
import model.Suivi;

public class DAOSuiviJPA implements IDAOSuivi{

	@Override
	public Suivi findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Suivi b = em.find(Suivi.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Suivi> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Suivi",Suivi.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Suivi objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Suivi update(Suivi objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Suivi objet) {
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
		Suivi d=em.find(Suivi.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}
