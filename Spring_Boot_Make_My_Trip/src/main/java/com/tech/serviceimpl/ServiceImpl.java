package com.tech.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.model.Train;
import com.tech.repository.TrainRepository;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	TrainRepository trp;

	@Override
	public String saveTrain(Train t) {

		trp.save(t);

		return "Train data is saved";
	}

	@Override
	public String addTrains(List<Train> t) {

		trp.saveAll(t);

		return "All Data Saved successfully";
	}

	@Override
	public String updateTrain(Train t) {
		Optional<Train> trn = trp.findById(t.getTrainId());
		if (trn.isPresent()) {
			trp.save(t);
			return "Train id " + t.getTrainId() + " data is update successfully";
		} else {
			return "train id not found";
		}
	}

	@Override
	public Optional<Train> getTrain(String tid) {
		Optional<Train> train = trp.findById(tid);

		return train;

	}

	@Override
	public String deleteTrain(String tid) {

		Optional<Train> trn = trp.findById(tid);
		if (trn.isPresent()) {
			trp.deleteById(tid);
			return "train id " + tid + " delete successfully";
		} else {
			return "Train id " + tid + " not found";
		}

	}

	@Override
	public List<Train> getTrains() {

		Iterable<Train> trains = trp.findAll();
		return (List<Train>) trains;
	}

}
