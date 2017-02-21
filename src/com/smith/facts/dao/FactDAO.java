package com.smith.facts.dao;

import java.util.List;

import com.smith.facts.bean.Facts;

public interface FactDAO {

	public List<Facts> getFact(Integer factId) throws Exception;
	public List<Facts> getFactsCategory(String category) throws Exception;
	public List<String> getDistinctcatergories() throws Exception;
	public List<Integer> getCountCategories() throws Exception;
	
}
