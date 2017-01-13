package be.vdab.services;

import javax.persistence.EntityManager;
import be.vdab.filters.JPAFilter;

public class AbstractService {
	
	private EntityManager getEntityManager(){
		return JPAFilter.getEntitymanager();
	}
	
	void begin(){
		getEntityManager().getTransaction().begin();
	}
	
	void commit(){
		getEntityManager().getTransaction().commit();
	}
	
	void rollback(){
		getEntityManager().getTransaction().rollback();
	}

}
