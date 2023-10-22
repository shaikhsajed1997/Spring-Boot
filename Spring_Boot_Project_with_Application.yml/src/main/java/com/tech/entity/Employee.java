package com.tech.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private String emp_Id;
	
	private String emp_Name;
	
	private String emp_Address;
	
	private String emp_MobileNumber;

	public String getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_Address() {
		return emp_Address;
	}

	public void setEmp_Address(String emp_Address) {
		this.emp_Address = emp_Address;
	}

	public String getEmp_MobileNumber() {
		return emp_MobileNumber;
	}

	public void setEmp_MobileNumber(String emp_MobileNumber) {
		this.emp_MobileNumber = emp_MobileNumber;
	}
	

}
