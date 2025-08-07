package LLD_JAN_HW.parking_lot_hw.models;

import java.util.HashMap;
import java.util.Map;

import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;

public class Dashboard {

	private Map<VehicleType, Integer> emptySlots;
	private Map<VehicleType, Integer> occupiedSlots;

	public Dashboard() {
		emptySlots = new HashMap<VehicleType, Integer>();
		occupiedSlots = new HashMap<VehicleType, Integer>();
	}

	public Map<VehicleType, Integer> getEmptySlots() {
		return emptySlots;
	}

	public void setEmptySlots(Map<VehicleType, Integer> emptySlots) {
		this.emptySlots = emptySlots;
	}

	public Map<VehicleType, Integer> getOccupiedSlots() {
		return occupiedSlots;
	}

	public void setOccupiedSlots(Map<VehicleType, Integer> occupiedSlots) {
		this.occupiedSlots = occupiedSlots;
	}

	public void update(VehicleType vtype, boolean occupied) {
		if (occupied) {
			emptySlots.put(vtype, emptySlots.get(vtype) - 1);
			occupiedSlots.put(vtype, occupiedSlots.getOrDefault(vtype, 0) + 1);
		} else {
			emptySlots.put(vtype, emptySlots.get(vtype) + 1);
			occupiedSlots.put(vtype, occupiedSlots.getOrDefault(vtype, 0) - 1);
		}
	}

	public void display() {
		System.out.println("Empty slots: " + emptySlots + "  " + "Occupied Slots: " + occupiedSlots);
	}

}
