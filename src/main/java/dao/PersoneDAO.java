package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Persona;

public class PersoneDAO {
	private final EntityManager em;

	public PersoneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
	}

}
