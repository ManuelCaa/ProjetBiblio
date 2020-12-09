package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOAdmin;
import model.Admin;

public class DAOAdminJPA implements IDAOAdmin {

	@Override
	public Admin findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Admin b = em.find(Admin.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Admin> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Admin",Admin.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Admin objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Admin update(Admin objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Admin objet) {
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
		Admin d=em.find(Admin.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
	
	
}
