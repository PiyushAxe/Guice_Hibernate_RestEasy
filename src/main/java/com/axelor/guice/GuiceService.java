package com.axelor.guice;
import javax.persistence.EntityManager;

import com.axelor.pojo.*;


import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class GuiceService {
	
	@Inject
	public EntityManager em;
	
	@Transactional
	public void save(Object user) {
		
		em.persist(user);
	}

	@Transactional
	public void remove(int id) {
		
		Name name = em.find(Name.class,id);
		
		em.remove(name);
	}

	public void updat(int id,int number) {
		
		Name name = em.find(Name.class,id);
		
		MobileNum numb = new MobileNum();
		numb.setNumber(number);
		
		name.getNumber().add(numb);
		
		save(name);
		
	}

}