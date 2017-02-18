package com.smith.facts.resources;

import com.smith.facts.business.service.FactServiceImpl;
import com.smith.facts.dao.FactDAOImpl;

public class Factory {

	public static FactServiceImpl createFactService(){
		return new FactServiceImpl();
	}	
	public static FactDAOImpl createFactDAO()
	{ 
		return new FactDAOImpl();
	}
	
}
