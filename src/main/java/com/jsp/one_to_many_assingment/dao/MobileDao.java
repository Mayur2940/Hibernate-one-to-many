package com.jsp.one_to_many_assingment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_many_assingment.dto.Mobile;
import com.jsp.one_to_many_assingment.dto.Sim;

public class MobileDao {
	
	SimDao simDao = new SimDao();
	
	EntityManager entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	//save method for college
	public Mobile saveMobile(Mobile mobile , int simId) {
		
		List<Sim> sim = simDao.displaySim();
		
		if(sim != null) {
			for(Sim sim2 : sim) {
				
				if(sim2.getSimId()==simId) {
					
					List<Sim> sims = new ArrayList<Sim>();
					sims.add(sim2);
					mobile.setSim(sims);
					entityTransaction.begin();
					entityManager.persist(mobile);
					entityTransaction.commit();
				}
			}
		}
		return mobile;
	}
	
	
	//Mobile display method
	public List<Mobile> displayMobile()
	{
		String displayQuery = "SELECT m FROM Mobile m";
		
		Query query = entityManager.createQuery(displayQuery);
		
		List<Mobile> list = query.getResultList();
		
		
		return list;
		
		
	}
	
	
	//Update method simById
	public void updateSimByMobile(int simId, String simName)
	{
		List<Mobile> mobiles = displayMobile();
		
		for (Mobile mobile : mobiles) {
			
			List<Sim> sims = mobile.getSim();
			
			for (Sim sim : sims) {
				
				
				if(sim.getSimId()==simId) {
					
					sim.setSimName(simName);
					
					entityTransaction.begin();
					entityManager.merge(sim);
					entityTransaction.commit();
				}
			}
		}
	}
	
	
	
}
