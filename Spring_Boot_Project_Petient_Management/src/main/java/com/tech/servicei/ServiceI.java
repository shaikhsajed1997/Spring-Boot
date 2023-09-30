package com.tech.servicei;

import java.util.List;
import java.util.Optional;

import com.tech.model.Patient;

public interface ServiceI {
	
	public String addPatient(Patient p);
	
	public String addPatients(List<Patient> p);
	
	public Optional<Patient> getPatient(String pid);
	
	public String deletePatient(String pid);
	
	public String updatePatient(Patient p);
}
