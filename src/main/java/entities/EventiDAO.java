package entities;

import java.util.UUID;

import javax.persistence.EntityManager;

public class EventiDAO {
	private final EntityManager em;

	public EventiDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento e) {
	}

	public Evento findById(UUID id) {
		return null;
	}
		
	public void delete(UUID id) {
	}
	}

