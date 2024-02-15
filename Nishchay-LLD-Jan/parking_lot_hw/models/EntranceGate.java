package LLD_JAN_HW.parking_lot_hw.models;

import java.time.LocalDateTime;
import java.util.Optional;

import LLD_JAN_HW.parking_lot_hw.Strategy.EntranceGateStrategy;

public class EntranceGate {
	EntranceGateStrategy entranceGateStrategy;

	public EntranceGate(EntranceGateStrategy entranceGateStrategy) {
		this.entranceGateStrategy = entranceGateStrategy;
	}

	public Ticket parkVehicle(String building_id, Vehicle vehicle, ParkingLot parkingLot) {
		System.out.println("Finding Spot for " + vehicle.getRegistrationNumber() + " in Parking lot");
		Building buildingbyBuildingID = parkingLot.findBuildingbyBuildingID(building_id, parkingLot);
		Optional<ParkingSpace> ps = entranceGateStrategy.findSpace(buildingbyBuildingID, vehicle);
		if (ps.isPresent()) {
			Ticket ticket = new Ticket();
			ticket.setParkingSpace(ps.get());
			ticket.setVehicle(vehicle);
			ticket.setInTime(LocalDateTime.now());
			ticket.setTicket_id(String.join("_", ps.get().getBuilding_id(), String.valueOf(ps.get().getFloor_num()),
					String.valueOf(ps.get().getParking_id()), vehicle.getRegistrationNumber()));
			System.out.println("Ticket generated:" + ticket.getTicket_id());
			return ticket;
		}
		throw new RuntimeException("No Spots available for " + vehicle.getType());
	}
}
