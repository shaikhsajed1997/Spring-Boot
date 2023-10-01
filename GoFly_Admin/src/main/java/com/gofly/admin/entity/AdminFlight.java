package com.gofly.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class AdminFlight {
	
	@Id
	@NotBlank(message="Flight Id is missing")
	private String flightId;
	
	@NotBlank(message = "Flight Name is missing")
	private String flightName;
	
	@NotBlank(message = "Flight Company is not spacified")
	private String flightCompany;
	
	@NotBlank(message = "Flight Departure date is missing")
	private String flightDepartureDate;
	
	@NotBlank(message = "Flight Arrival date is missing")
	private String flightArrivalDate;
	
	@NotBlank(message = "Flight Departure time is missing")
	private String flightDepartureTime;
	
	@NotBlank(message = "Flight Arrival time is missing")
	private String flightArrivalTime;
	
	@NotBlank(message = "Flight Duration time is missing")
	private String flightDuration;
	
	@NotBlank(message = "Flight Source is missing")
	private String flightSource;
	
	@NotBlank(message = "Flight Destination is missing")
	private String flightDestination;
	
	@NotBlank(message = "Available Seat is missing")
	private String availableSeats;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public String getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(String flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}

	public String getFlightArrivalDate() {
		return flightArrivalDate;
	}

	public void setFlightArrivalDate(String flightArrivalDate) {
		this.flightArrivalDate = flightArrivalDate;
	}

	public String getFlightDepartureTime() {
		return flightDepartureTime;
	}

	public void setFlightDepartureTime(String flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}

	public String getFlightArrivalTime() {
		return flightArrivalTime;
	}

	public void setFlightArrivalTime(String flightArrivalTime) {
		this.flightArrivalTime = flightArrivalTime;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getFlightSource() {
		return flightSource;
	}

	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}
	

}
