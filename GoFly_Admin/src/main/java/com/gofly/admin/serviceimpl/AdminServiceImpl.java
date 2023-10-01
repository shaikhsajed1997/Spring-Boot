package com.gofly.admin.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofly.admin.entity.AdminFlight;
import com.gofly.admin.model.RescheduleFlight;
import com.gofly.admin.repository.AdminRepository;
import com.gofly.admin.servicei.AdminServiceI;

@Service
public class AdminServiceImpl implements AdminServiceI {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public String addFlight(AdminFlight flight) {

		adminRepository.save(flight);

		return "Flight Id " + flight.getFlightId() + " added successfully";
	}

	@Override
	public Optional<AdminFlight> getFlight(String flightId) {

		Optional<AdminFlight> flight = adminRepository.findById(flightId);
		return flight;
	}

	@Override
	public String deleteFlight(String flightId) {
		Optional<AdminFlight> flightbyid = adminRepository.findById(flightId);

		if (flightbyid.isPresent()) {

			adminRepository.deleteById(flightId);
			return "Flight Id: " + flightId + " is deleted successfully";
		} else {
			return null;
		}

	}

	@Override
	public String updateFlight(AdminFlight flight) {
		
		Optional<AdminFlight> flightbyid = adminRepository.findById(flight.getFlightId());
		if(flightbyid.isPresent()) {
			
			AdminFlight adminFlight = adminRepository.save(flight);
			return "Flight Id: "+adminFlight.getFlightId()+" is Updated successfully";
		}else {
		
		return null;
		}
	}

	@Override
	public AdminFlight rescheduleFlight(RescheduleFlight flightReschedule) {
		
		Optional<AdminFlight> optionalFlight = adminRepository.findById(flightReschedule.getFlightId());
		if(optionalFlight.isPresent()) {
			
			AdminFlight adminFlight = optionalFlight.get();
			adminFlight.setFlightArrivalDate(flightReschedule.getFlightArrivalDate());
			adminFlight.setFlightArrivalTime(flightReschedule.getFlightArrivalTime());
			adminFlight.setFlightDepartureDate(flightReschedule.getFlightDepartureDate());
			adminFlight.setFlightDepartureTime(flightReschedule.getFlightDepartureTime());
			adminFlight.setFlightDuration(flightReschedule.getFlightDuration());
			
			AdminFlight savedFlight = adminRepository.save(adminFlight);
			return savedFlight;
		}
		
		return null;
	}

}
