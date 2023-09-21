package com.tech.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Train {
	@Id
	private String trainId;

	private String trainName;

	private String trainDepartureTime;

	private String trainArrivelTime;

	private String trainDepartureDate;

	private String trainArrivelDate;
	
	private int trainAvailableSeat;

	public int getTrainAvailableSeat() {
		return trainAvailableSeat;
	}

	public void setTrainAvailableSeat(int trainAvailableSeat) {
		this.trainAvailableSeat = trainAvailableSeat;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainDepartureTime() {
		return trainDepartureTime;
	}

	public void setTrainDepartureTime(String trainDepartureTime) {
		this.trainDepartureTime = trainDepartureTime;
	}

	public String getTrainArrivelTime() {
		return trainArrivelTime;
	}

	public void setTrainArrivelTime(String trainArrivelTime) {
		this.trainArrivelTime = trainArrivelTime;
	}

	public String getTrainDepartureDate() {
		return trainDepartureDate;
	}

	public void setTrainDepartureDate(String trainDepartureDate) {
		this.trainDepartureDate = trainDepartureDate;
	}

	public String getTrainArrivelDate() {
		return trainArrivelDate;
	}

	public void setTrainArrivelDate(String trainArrivelDate) {
		this.trainArrivelDate = trainArrivelDate;
	}

}
