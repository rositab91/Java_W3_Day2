package java_W3_Day2.app;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.EventiDAO;
import entities.Evento;
import entities.TipoEvento;
import utils.JpaUtil;

public class Application {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		Evento day1 = new Evento("Fashion Week", "2023-08-05", "Evento moda", TipoEvento.PUBBLICO, 500);
		EventiDAO sd = new EventiDAO(em);
		// sd.save(day1);

		Evento eventoDay1 = sd.findById(UUID.fromString("41a9a6b1-005a-4dc6-acc0-068872cfb66d"));
		System.out.println(eventoDay1);
		
		sd.findByIdAndDelete(UUID.fromString("41a9a6b1-005a-4dc6-acc0-068872cfb66d"));
		
		
		// Le entity manager e factory vanno sempre chiuse
		em.close();
		emf.close();
	}


}
