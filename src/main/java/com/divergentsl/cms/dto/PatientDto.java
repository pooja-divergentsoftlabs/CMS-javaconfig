package com.divergentsl.cms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class PatientDto {
	
	@NotBlank(message = "id should not be null")
	private String pid; 
	
	@NotBlank(message="name can not be blank")
	private String pname;
	
	@NotBlank(message="address can not be blank")
	private String paddress;
	
	@Size(min=10,max=10,message="Number must contain 10 digits only")
	private String pcontactnumber;
	
	@NotBlank(message = "age should not be null")
	private String page;
	
	@NotBlank(message = "weight should not be null")
	private String pweight;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getPcontactnumber() {
		return pcontactnumber;
	}

	public void setPcontactnumber(String pcontactnumber) {
		this.pcontactnumber = pcontactnumber;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPweight() {
		return pweight;
	}

	public void setPweight(String pweight) {
		this.pweight = pweight;
	}

	
}
