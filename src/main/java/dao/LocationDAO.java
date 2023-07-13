package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Location;

public class LocationDAO {
	
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location l) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(l);
		t.commit(); 
	}
}
	

