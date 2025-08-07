package LLD_JAN_HW.parking_lot_hw.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpacePOJO {

	private List<ParkingSpace> emptySpaces;
	private List<ParkingSpace> occupiedSpaces;

	public ParkingSpacePOJO() {
		this.emptySpaces = new ArrayList<>();
		this.occupiedSpaces = new ArrayList<>();
	}

	public List<ParkingSpace> getEmptySpaces() {
		return emptySpaces;
	}

	public void setEmptySpaces(List<ParkingSpace> emptySpaces) {
		this.emptySpaces = emptySpaces;
	}

	public List<ParkingSpace> getOccupiedSpaces() {
		return occupiedSpaces;
	}

	public void setOccupiedSpaces(List<ParkingSpace> occupiedSpaces) {
		this.occupiedSpaces = occupiedSpaces;
	}

}
