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
		Location casa = new Location("Casa Nadia", "Lamezia");

		ld.save(hotel);
		ld.save(casa);
		
				Persona alpha = new Persona("Rosita", "Bongiovanni", "rositab91@live.it", LocalDate.of(1991, 3, 26), Sesso.FEMMINA, new HashSet<>());
				Persona beta = new Persona("Giada", "Bongiovanni", "jadin@live.it", LocalDate.of(1993, 5, 5),
						Sesso.FEMMINA, new HashSet<>());
				Persona gamma = new Persona("Giuseppe", "Rumoro", "giuseppe.rumoro@gmail.com",
						LocalDate.of(1990, 2, 8), Sesso.MASCHIO, new HashSet<>());
				
				pd.save(alpha);
				pd.save(beta);
				pd.save(gamma);

				Evento moda = new Evento("Fashion Week", LocalDate.of(2023, 2, 05), "Moda", TipoEvento.PUBBLICO, 500,
						hotel, new HashSet<>());
				ed.save(moda);
				logger.info(moda.getTitolo() + " è stato salvato");
		
				Evento laurea = new Evento("Festa Giada", LocalDate.of(2023, 7, 30), "Laurea", TipoEvento.PRIVATO, 20,
						casa, new HashSet<>());
				ed.save(laurea);
				logger.info(laurea.getTitolo() + " è stato salvato");

				Set<Partecipazione> partecipazioni = new HashSet<>();
		
				Partecipazione partecipazioneA = new Partecipazione(alpha, moda, Stato.DA_CONFERMARE);
				Partecipazione partecipazioneB = new Partecipazione(gamma, laurea, Stato.CONFERMATO);

				partecipazioni.add(partecipazioneA);
				partecipazioni.add(partecipazioneB);


				pDao.save(partecipazioneA);
				pDao.save(partecipazioneB);


		// Le entity manager e factory vanno sempre chiuse
		em.close();
		emf.close();
	}
}
