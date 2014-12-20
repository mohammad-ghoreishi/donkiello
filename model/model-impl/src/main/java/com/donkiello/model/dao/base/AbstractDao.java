package com.donkiello.model.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {

	@PersistenceContext( unitName="DonPU")
	private EntityManager em;
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASamplePU");

	protected AbstractDao() {
          
//		em = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return em;
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

}