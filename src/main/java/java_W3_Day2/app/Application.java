package java_W3_Day2.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.EventiDAO;
import utils.JpaUtil;

public class Application {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("ciao");

		EventiDAO sd = new EventiDAO(em);

	}

}
