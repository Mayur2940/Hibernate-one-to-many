package com.jsp.one_to_many_assingment.service;

import java.util.List;

import com.jsp.one_to_many_assingment.dao.MobileDao;
import com.jsp.one_to_many_assingment.dto.Mobile;

public class MobileService {

	MobileDao mobileDao = new MobileDao();
	
	//save method for college
		public Mobile saveMobile(Mobile mobile , int simId) {
			
			return mobileDao.saveMobile(mobile, simId);
		}
		

		//Mobile display method
		public List<Mobile> displayMobile()
		{
			return mobileDao.displayMobile();
		}
		
		//Update method simById
		public void updateSimByMobile(int simId, String simName)
		{
			mobileDao.updateSimByMobile(simId, simName);
		}
}
