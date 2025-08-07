package LLD_JAN_HW.parking_lot_hw.models;

import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;

public class ParkingSpace {

	private String building_id;
	private int floor_num;
	private VehicleType vehicleType;
	private int parking_id;
	private boolean isOccupied;

	public ParkingSpace(String building_id, int floor_num, VehicleType vehicleType, int parking_id,
			boolean isOccupied) {
		super();
		this.building_id = building_id;
		this.floor_num = floor_num;
		this.vehicleType = vehicleType;
		this.parking_id = parking_id;
		this.isOccupied = isOccupied;
	}

	public ParkingSpace() {
	}

	public String getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}

	public int getFloor_num() {
		return floor_num;
	}

	public void setFloor_num(int floor_num) {
		this.floor_num = floor_num;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getParking_id() {
		return parking_id;
	}

	public void setParking_id(int parking_id) {
		this.parking_id = parking_id;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
