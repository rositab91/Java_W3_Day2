package java_W3_Day2.app;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventiDAO;
import dao.LocationDAO;
import dao.PartecipazioniDAO;
import dao.PersoneDAO;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;
import utils.JpaUtil;

public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		EventiDAO ed = new EventiDAO(em);
		PersoneDAO pd = new PersoneDAO(em);
		LocationDAO ld = new LocationDAO(em);
		PartecipazioniDAO pDao = new PartecipazioniDAO(em);
		
		Location hotel = new Location("Hilton", "Paris");
		ld.save(hotel);
		
				Persona alpha = new Persona("Rosita", "Bongiovanni", "rositab91@live.it", LocalDate.of(1991, 3, 26), Sesso.FEMMINA, new HashSet<>());
				pd.save(alpha);

				Evento moda = new Evento("Fashion Week", LocalDate.of(2023, 2, 05), "Moda", TipoEvento.PRIVATO, 500,
						hotel, new HashSet<>());
				ed.save(moda);
				logger.info(moda.getTitolo() + " e' stato salvato");
		
				Set<Partecipazione> partecipazioni = new HashSet<>();
		
				Partecipazione partecipazioneAlfa = new Partecipazione(alpha, moda, Stato.CONFERMATO);
		

		partecipazioni.add(partecipazioneAlfa);


		pDao.save(partecipazioneAlfa);


		// Le entity manager e factory vanno sempre chiuse
		em.close();
		emf.close();
	}
}
