package com.aminfo.dao.generic.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class JPAServiceProvider {

	/**
	 * represents the JPA entity manager.
	 */
	@PersistenceContext(name = "DEFAULT", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
