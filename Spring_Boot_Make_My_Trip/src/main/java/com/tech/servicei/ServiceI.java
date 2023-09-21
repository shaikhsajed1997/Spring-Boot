package com.tech.servicei;

import java.util.List;
import java.util.Optional;

import com.tech.model.Train;

public interface ServiceI {
	
	public String saveTrain(Train t);
	
	public String addTrains(List<Train> t);
	
	public Optional<Train> getTrain(String tid);
	
	public String updateTrain(Train t);
	
	public String deleteTrain(String tid);
	
	public List<Train> getTrains();

}
