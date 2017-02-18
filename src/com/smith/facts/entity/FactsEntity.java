package com.smith.facts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACT_BOX")
public class FactsEntity {

	@Id
	@Column(name = "Fact_Id")
	private Integer factId;
	@Column(name = "Fact_category")
	private String factCategory;
	@Column(name = "Fact_Description")
	private String factDesc;
	public Integer getFactId() {
		return factId;
	}
	public void setFactId(Integer factId) {
		this.factId = factId;
	}
	public String getFactCategory() {
		return factCategory;
	}
	public void setFactCategory(String factCategory) {
		this.factCategory = factCategory;
	}
	public String getFactDesc() {
		return factDesc;
	}
	public void setFactDesc(String factDesc) {
		this.factDesc = factDesc;
	}

	
	
}


