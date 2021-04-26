package com.divergentsl.cms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class DrugDto {
	
	@NotNull(message="id should not be null")
	private String drugid;
	
	@NotBlank(message = "name should not be blank")
	private String drugname;
	
	@Size(min=5,max=50,message="description should be greater than 5 and less than 50")
	private String drugdescription;
	
	@NotNull(message="id should not be null")
	private String drugquantity;
	
	@NotNull(message = "price should not be null")
	private String drugprice;

	public String getDrugid() {
		return drugid;
	}

	public void setDrugid(String drugid) {
		this.drugid = drugid;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getDrugdescription() {
		return drugdescription;
	}

	public void setDrugdescription(String drugdescription) {
		this.drugdescription = drugdescription;
	}

	public String getDrugquantity() {
		return drugquantity;
	}

	public void setDrugquantity(String drugquantity) {
		this.drugquantity = drugquantity;
	}

	public String getDrugprice() {
		return drugprice;
	}

	public void setDrugprice(String drugprice) {
		this.drugprice = drugprice;
	}
	

}
