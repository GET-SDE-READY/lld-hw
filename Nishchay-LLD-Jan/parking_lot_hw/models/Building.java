package LLD_JAN_HW.parking_lot_hw.models;

import java.util.List;
import java.util.Map;

public class Building {
	private String building_id;
	private List<ParkingFloor> parkingFloorMap;
	private Dashboard dashboard;

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public Building() {
	}

	public String getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}

	public List<ParkingFloor> getParkingFloorMap() {
		return parkingFloorMap;
	}

	public void setParkingFloorMap(List<ParkingFloor> parkingFloorMap) {
		this.parkingFloorMap = parkingFloorMap;
	}

}
