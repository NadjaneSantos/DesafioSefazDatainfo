package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Nadjane 
 * 
 * Disponibiliza as EntityManager realizando conex�o com o banco
 * de dados em �nica instancia para todo projeto.
 *
 */

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		
		if(entityManager == null) {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("desafiosefaz");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
		
	}
}
