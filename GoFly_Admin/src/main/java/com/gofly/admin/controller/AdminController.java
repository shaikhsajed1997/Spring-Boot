package com.gofly.admin.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gofly.admin.adminconstants.AdminConstant;
import com.gofly.admin.entity.AdminFlight;
import com.gofly.admin.model.RescheduleFlight;
import com.gofly.admin.servicei.AdminServiceI;

@RestController
@RequestMapping("/admin")

public class AdminController {

	@Autowired
	AdminServiceI adminService;

	String responseMessage;
	HttpStatus httpstatus;

	@PostMapping("/flight/add")
	public ResponseEntity<Object> addFlight(@Valid @RequestBody AdminFlight flight, BindingResult result) {

		if (result.hasErrors()) {

			responseMessage = "Invalid Flight: " + result.getAllErrors();
			httpstatus = HttpStatus.BAD_REQUEST;

			return new ResponseEntity<Object>(responseMessage, httpstatus);
		} else {
			responseMessage = adminService.addFlight(flight);
			httpstatus = HttpStatus.CREATED;
			return new ResponseEntity<Object>(responseMessage, httpstatus);
		}
	}

	@GetMapping("/flight/{flightId}")
	public ResponseEntity<Object> getFlight(@PathVariable("flightId") String flightId) {

		Optional<AdminFlight> flight = adminService.getFlight(flightId);

		if (flight.isPresent()) {
			httpstatus = HttpStatus.OK;
			AdminFlight adminFlight = flight.get();
			return new ResponseEntity<Object>(adminFlight, httpstatus);
		} else {
			httpstatus = HttpStatus.NOT_FOUND;
			responseMessage = "Flight Id: " + flightId + " is not found";

			return new ResponseEntity<Object>(responseMessage, httpstatus);
		}

	}

	@DeleteMapping("/flight/delete/{flightId}")
	public ResponseEntity<Object> deleteFlight(@PathVariable("flightId") String flightid) {

		responseMessage = adminService.deleteFlight(flightid);
		if (responseMessage != null) {

			return new ResponseEntity<Object>(responseMessage, httpstatus);
		} else {
			responseMessage = "Flight Id " + flightid + " is Not found";
			httpstatus = HttpStatus.NOT_FOUND;
			return new ResponseEntity<Object>(responseMessage, httpstatus);
		}
	}

	@PutMapping("/flight/update")
	public ResponseEntity<Object> updateFlight(@Valid @RequestBody AdminFlight flight, BindingResult result) {

		if (result.hasErrors()) {

			responseMessage = "Invalid Flight: " + result.getAllErrors();
			httpstatus = HttpStatus.BAD_REQUEST;

			return new ResponseEntity<Object>(responseMessage, httpstatus);
		}
		if (flight.getFlightId() != null) {

			responseMessage = adminService.updateFlight(flight);

			if (responseMessage != null) {
				httpstatus = HttpStatus.OK;
				return new ResponseEntity<Object>(responseMessage, httpstatus);
			} else {
				responseMessage = "Flight Id " + flight.getFlightId() + " is Not found";
				httpstatus = HttpStatus.NOT_FOUND;
				return new ResponseEntity<Object>(responseMessage, httpstatus);
			}
		} else {
			responseMessage = "Flight Id is should not be Null";
			httpstatus = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<Object>(responseMessage, httpstatus);
		}

	}

	@PatchMapping("/flight/reschedule")
	public ResponseEntity<Object> rescheduleFlight(@Valid @RequestBody RescheduleFlight flightReschedule,
			BindingResult result) {

		if (result.hasErrors()) {

			responseMessage = "Invalid Flight: " + result.getAllErrors();
			httpstatus = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<Object>(responseMessage, httpstatus);

		}

		AdminFlight flight = adminService.rescheduleFlight(flightReschedule);

		if (flight != null) {
			httpstatus = HttpStatus.OK;
			return new ResponseEntity<Object>(flight, httpstatus);
		}

		responseMessage = "Flight Id " + flightReschedule.getFlightId() + " is Not exist";
		httpstatus = HttpStatus.NOT_FOUND;
		return new ResponseEntity<Object>(responseMessage, httpstatus);

	}

}
