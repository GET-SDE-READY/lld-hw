package LLD_JAN_HW.parking_lot_hw.models;

import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;

public class Vehicle {

	private VehicleType type;
	private String registrationNumber;

	public Vehicle(String registrationNumber, VehicleType type) {
		super();
		this.type = type;
		this.registrationNumber = registrationNumber;
	}

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
