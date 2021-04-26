package com.divergentsl.cms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class DoctorDto {
	
	@NotBlank(message="id cannot be null")
	private String did;
	
	@NotBlank(message="name can not be blank")
	private String dname;
	
	@NotBlank(message="speciality cannot be null")
	@Size(max=20,message="speciality should not exceed the limit")
	private String dspeciality;
	
	@Size(min=10,max=10,message="Number must contain 10 digits only")
	private String dcontactnumber;
	
	@NotBlank(message="fees can not null")
	private String dfees;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDspeciality() {
		return dspeciality;
	}

	public void setDspeciality(String dspeciality) {
		this.dspeciality = dspeciality;
	}

	public String getDcontactnumber() {
		return dcontactnumber;
	}

	public void setDcontactnumber(String dcontactnumber) {
		this.dcontactnumber = dcontactnumber;
	}

	public String getDfees() {
		return dfees;
	}

	public void setDfees(String dfees) {
		this.dfees = dfees;
	}
	
	

}
