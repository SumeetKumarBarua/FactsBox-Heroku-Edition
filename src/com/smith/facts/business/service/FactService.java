package com.smith.facts.business.service;

import java.util.List;

import com.smith.facts.bean.Facts;

public interface FactService {

	public List<Facts> getFacts(Integer factId) throws Exception;
	public List<Facts> getFactsCategory(String category) throws Exception;
	public List<String> getDistinctcatergories() throws Exception;
	public List<Integer> getCountCategories() throws Exception;
}
