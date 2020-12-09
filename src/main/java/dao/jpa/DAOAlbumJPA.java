package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOAlbum;
import model.Album;

public class DAOAlbumJPA implements IDAOAlbum {

	@Override
	public Album findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Album b = em.find(Album.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Album> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Album",Album.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Album objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Album update(Album objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Album objet) {
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
		Album d=em.find(Album.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
}
