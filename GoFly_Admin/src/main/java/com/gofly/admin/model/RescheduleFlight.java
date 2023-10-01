package com.gofly.admin.model;

import javax.validation.constraints.NotBlank;

public class RescheduleFlight {

	@NotBlank(message="Flight Id is missing")
	private String flightId;
	
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

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
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
	
	
}
