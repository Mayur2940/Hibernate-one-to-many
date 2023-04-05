package com.jsp.one_to_many_assingment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_many_assingment.dto.Sim;

public class SimDao {
	
	EntityManager entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//insert method for Sim
	public Sim insertSim(Sim sim)
	{
		entityTransaction.begin();
		entityManager.persist(sim);
		entityTransaction.commit();
		
		System.out.println("*****Data******Inserted");
		
		return sim;
		
	}
	
	//getById for Sim
	public Sim getById(int simId)
	{
		Sim sim = entityManager.find(Sim.class, simId);
		
		if(sim != null) {
			return sim;
		}
		else {
			return null;
		}
	}
	
	
	//display method for sim
	public List<Sim> displaySim()
	{
		String displayQuery="SELECT s FROM Sim s";
		
		Query query = entityManager.createQuery(displayQuery);
		
		List<Sim> list = query.getResultList();
		
		
		return list;
		
	}
}
