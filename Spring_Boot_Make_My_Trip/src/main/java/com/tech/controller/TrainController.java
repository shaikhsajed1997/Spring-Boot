package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Train;
import com.tech.servicei.ServiceI;

@RestController
public class TrainController {

	@Autowired
	ServiceI si;

	//to add train data in database
	@PostMapping("/train/add")
	public ResponseEntity<Object> saveTrain(@RequestBody Train t) {
		String msg =null;
		if(t.getTrainId()!=null) {
		 msg = si.saveTrain(t);
		return new ResponseEntity<Object>(msg, HttpStatus.CREATED);
		}else {
			msg="You are insert null object Or Null id";
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_ACCEPTABLE);
		}

	}
    //to add multiple data in database
	@PostMapping("/trains/add")
	public ResponseEntity<Object> saveTrains(@RequestBody List<Train> t) {

		if (t.isEmpty() == false) {
			String msg = si.addTrains(t);

			return new ResponseEntity<Object>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>("You are insert empty object list", HttpStatus.BAD_REQUEST);
		}

	}
	//to get single train data
	@GetMapping("train/get/{tid}")
	public ResponseEntity<Object> getTrain(@PathVariable("tid") String tid) {

		Optional<Train> train = si.getTrain(tid);
		if (train.isPresent()) {
			Train trn = train.get();
			return new ResponseEntity<Object>(trn, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Train not found", HttpStatus.NOT_FOUND);
		}

	}
	//to update data
	@PutMapping("/train/update")
	public ResponseEntity<Object> updateTrain(@RequestBody Train t) {

		String msg = si.updateTrain(t);
		return new ResponseEntity<Object>(msg, HttpStatus.OK);

	}

	@DeleteMapping("train/{tid}")
	public ResponseEntity<Object> deleteTrain(@PathVariable("tid") String tid) {

		String msg = si.deleteTrain(tid);

		return new ResponseEntity<Object>(msg, HttpStatus.OK);

	}

	@GetMapping("/trains/get")
	public ResponseEntity<Object> getTrains() {

		List<Train> trains = si.getTrains();
		if(trains.isEmpty()==false) {

		return new ResponseEntity<Object>(trains, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("No Recods Found", HttpStatus.NOT_FOUND);
		}

	}

}
