package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOFiche;
import model.Fiche;

public class DAOFicheJPA implements IDAOFiche{
	@Override
	public Fiche findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Fiche b = em.find(Fiche.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Fiche> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Fiche",Fiche.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Fiche objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Fiche update(Fiche objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Fiche objet) {
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
		Fiche d=em.find(Fiche.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}
