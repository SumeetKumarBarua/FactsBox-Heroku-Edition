package com.smith.facts.business.service;


import java.util.List;

import com.smith.facts.bean.Facts;
import com.smith.facts.dao.FactDAO;
import com.smith.facts.resources.Factory;

/**
 * Service class to execute business logic
 * 
 * @author ETA
 */

public class FactServiceImpl implements FactService {

	public List<Facts> getFacts(Integer factId) throws Exception {
		// TODO Auto-generated method stub
		FactDAO dao=Factory.createFactDAO();
		List<Facts> result=dao.getFact(factId);
		return result;
	}


	public List<Facts> getFactsCategory(String category) throws Exception {
		FactDAO dao=Factory.createFactDAO();
		List<Facts> result=dao.getFactsCategory(category);
		return result;
	}
	
	public List<String> getDistinctcatergories() throws Exception{
		FactDAO dao=Factory.createFactDAO();
		List<String> result=dao.getDistinctcatergories();
		return result;
	}

	public List<Integer> getCountCategories() throws Exception {
		FactDAO dao=Factory.createFactDAO();
		List<Integer> result=dao.getCountCategories();
		return result;
	}
	
}
