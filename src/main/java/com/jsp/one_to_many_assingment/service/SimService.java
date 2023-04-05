package com.jsp.one_to_many_assingment.service;

import java.util.List;

import com.jsp.one_to_many_assingment.dao.SimDao;
import com.jsp.one_to_many_assingment.dto.Sim;

public class SimService {

	SimDao simDao = new SimDao();
	
	//insert method for Sim
		public Sim insertSim(Sim sim)
		{
			return simDao.insertSim(sim);
		}
		
		//getById for Sim
		public Sim getById(int simId)
		{
			return simDao.getById(simId);
		}
		
		//display method for sim
		public List<Sim> displaySim()
		{
			return simDao.displaySim();
		}
}
