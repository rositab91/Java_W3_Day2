package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Partecipazione;

public class PartecipazioniDAO {

	private final EntityManager em;

	public PartecipazioniDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
	}

	public Partecipazione findById(UUID id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}
}