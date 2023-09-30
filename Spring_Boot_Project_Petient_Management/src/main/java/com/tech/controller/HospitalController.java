package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Patient;
import com.tech.servicei.ServiceI;

@RestController
public class HospitalController {
	@Autowired
	ServiceI si;

	@PostMapping("/hospital/add")
	public ResponseEntity<Object> add(@RequestBody Patient p) {

		if (p.getP_Id() != null) {
			String msg = si.addPatient(p);

			return new ResponseEntity<Object>(msg, HttpStatus.CREATED);
			
		} else {
			
			return new ResponseEntity<Object>("You pass null object", HttpStatus.CREATED);
		}
	}

	@PostMapping("/hospital/patients/add")
	public ResponseEntity<Object> addMany(@RequestBody List<Patient> p) {

		if (p.isEmpty() == false) {
			try {
				String msg = si.addPatients(p);

				return new ResponseEntity<Object>(msg, HttpStatus.CREATED);
			} catch (Exception e) {
				String msg = "You are trying to pass null object in list or null id of object in list";
				return new ResponseEntity<Object>(msg, HttpStatus.CREATED);
			}
		} else {
			return new ResponseEntity<Object>("You pass empty list", HttpStatus.CREATED);
		}

	}

	@GetMapping("/hospital/{pId}")
	public ResponseEntity<Object> searchPatient(@PathVariable("pId") String pid) {

		Optional<Patient> p = si.getPatient(pid);
		if (p.isPresent()) {
			Patient patient = p.get();
			return new ResponseEntity<Object>(patient, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Patient not found", HttpStatus.OK);
		}

	}

	@DeleteMapping("/hospital/{pid}")
	public ResponseEntity<Object> deletePatient(@PathVariable("pid") String pid) {
		try {
			Integer id = Integer.parseInt(pid);

			String response = si.deletePatient(pid);

			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("You should enter only integer value in string", HttpStatus.OK);
		}

	}

	@PatchMapping("/hospital/patch")
	public ResponseEntity<Object> update(@RequestBody Patient p) {
		if (p.getP_Id() != null) {
			String response = si.updatePatient(p);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("You pass the null primary id", HttpStatus.OK);
		}

	}
}
