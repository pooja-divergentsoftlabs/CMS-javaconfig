package com.divergentsl.cms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class LabtestDto {
	
	
	@NotBlank(message = "id should not be null")
	private String testid;
	
	@Size(min=5,max=20,message="testname should be greater than 5 and less than 20")
	private String testname;
	
	@NotBlank(message = "patient id should not be null")
	private String pid;
	
	@NotBlank(message = "fees should not be null")
	private String testfee;

	@NotBlank(message = "fees should not be null")
	public String getTestid() {
		return testid;
	}

	public void setTestid(String testid) {
		this.testid = testid;
	}

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTestfee() {
		return testfee;
	}

	public void setTestfee(String testfee) {
		this.testfee = testfee;
	}

}
