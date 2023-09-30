package com.tech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Patient {

	@Id
	private String p_Id;
	
	private String p_Name;
	
	private String p_Address;
	
	private String mobile_Number;

	public String getP_Id() {
		return p_Id;
	}

	public void setP_Id(String p_Id) {
		this.p_Id = p_Id;
	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public String getP_Address() {
		return p_Address;
	}

	public void setP_Address(String p_Address) {
		this.p_Address = p_Address;
	}

	public String getMobile_Number() {
		return mobile_Number;
	}

	public void setMobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	
	
}
