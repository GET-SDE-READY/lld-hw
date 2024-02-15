package LLD_JAN_HW.parking_lot_hw.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	private static List<Building> building_having_parking_floors;

	public ParkingLot() {
		this.building_having_parking_floors = new ArrayList<Building>();
	}

	public List<Building> getBuilding_having_parking_floors() {
		return building_having_parking_floors;
	}

	public void setBuilding_having_parking_floors(List<Building> building_having_parking_floors) {
		this.building_having_parking_floors = building_having_parking_floors;
	}

	public Building findBuildingbyBuildingID(String buildingId, ParkingLot parkinglot) {
		List<Building> building_having_parking_floors = parkinglot.getBuilding_having_parking_floors();
		for (Building b : building_having_parking_floors) {
			if (b.getBuilding_id() == buildingId) {
				return b;
			}
		}
		throw new RuntimeException("No such Building exists");
	}

}
