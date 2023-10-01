package com.gofly.admin.servicei;

import java.util.Optional;

import com.gofly.admin.entity.AdminFlight;
import com.gofly.admin.model.RescheduleFlight;

public interface AdminServiceI {
	
	public String addFlight(AdminFlight flight);
	
	public Optional<AdminFlight> getFlight(String flightId);
	
	public String deleteFlight(String flightId);
	
	public String updateFlight(AdminFlight flight);
	
	public AdminFlight rescheduleFlight(RescheduleFlight flightReschedule);
	

}
