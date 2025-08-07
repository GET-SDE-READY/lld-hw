package LLD_JAN_HW.parking_lot_hw.models;

import java.util.HashMap;
import java.util.Map;

import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;

public class ParkingFloor {
	private String building_id;
	private int floor_num;
	private Map<VehicleType, ParkingSpacePOJO> parkingSpaceMap;

	public ParkingFloor() {
	}

	public ParkingFloor(String building_id, int floor_num, Map<VehicleType, ParkingSpacePOJO> parkingSpaceMap) {
		super();
		this.building_id = building_id;
		this.floor_num = floor_num;
		this.parkingSpaceMap = new HashMap<>();
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

	public Map<VehicleType, ParkingSpacePOJO> getParkingSpaceMap() {
		return parkingSpaceMap;
	}

	public void setParkingSpaceMap(Map<VehicleType, ParkingSpacePOJO> parkingSpaceMap) {
		this.parkingSpaceMap = parkingSpaceMap;
	}

}
