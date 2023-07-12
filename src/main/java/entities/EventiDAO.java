package entities;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventiDAO {
	private final EntityManager em;

	public EventiDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento e) {
		EntityTransaction t = em.getTransaction();
		t.begin(); // inizia la transazione

		em.persist(e);

		t.commit(); // termina la transazione
		System.out.println("Evento salvato con successo");
	}

	public Evento findById(UUID id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}
	public void findByIdAndDelete(UUID id) {
		// Faccio una find per ottenere l evento
		
		Evento found = em.find(Evento.class, id);
		if(found != null) {
		// Poi elimino quell evento
			// Ottengo la transazione
		EntityTransaction t = em.getTransaction();
			// Faccio partire la transazione
		t.begin();
			// Rimuovo l oggetto
		em.remove(found);
			// Faccio il ccmmit della transazione
			t.commit();
			System.out.println("Evento eliminato con successo ");
		} else {
			System.out.println("Evento non trovato");
		}
}
}