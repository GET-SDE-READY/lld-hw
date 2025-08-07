package LLD_JAN_HW.parking_lot_hw.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;
import LLD_JAN_HW.parking_lot_hw.models.Building;
import LLD_JAN_HW.parking_lot_hw.models.Dashboard;
import LLD_JAN_HW.parking_lot_hw.models.ParkingFloor;
import LLD_JAN_HW.parking_lot_hw.models.ParkingLot;
import LLD_JAN_HW.parking_lot_hw.models.ParkingSpace;
import LLD_JAN_HW.parking_lot_hw.models.ParkingSpacePOJO;
import LLD_JAN_HW.parking_lot_hw.models.Ticket;
import LLD_JAN_HW.parking_lot_hw.models.Vehicle;

public class ParkingService {

	private ParkingLot parkingLot;

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public ParkingService() {
		parkingLot = new ParkingLot();
	}

	public void createParkingLot(String building_id, int floors, Map<VehicleType, Integer> vehicleTypeToCountMap) {
		Building building = new Building();
		// update dashboard emptySlots
		Dashboard dashboard = new Dashboard();
		Map<VehicleType, Integer> emptySlots = dashboard.getEmptySlots();
		for (VehicleType vt : vehicleTypeToCountMap.keySet()) {
			emptySlots.put(vt, floors * vehicleTypeToCountMap.get(vt));
		}
		// ------
		building.setDashboard(dashboard);
		building.setBuilding_id(building_id);
		List<ParkingFloor> parkingFloorsList = new ArrayList<>();
		for (int f = 0; f < floors; f++) {
			ParkingFloor parkingFloor = new ParkingFloor();
			parkingFloor.setBuilding_id(building_id);
			parkingFloor.setFloor_num(f);
			int parking_id = 0;
			StringBuilder sb = new StringBuilder(
					"Parking Ids -> Building -> " + building_id + " floor-> " + String.valueOf(f));
			Map<VehicleType, ParkingSpacePOJO> parkMap = new HashMap<VehicleType, ParkingSpacePOJO>();
			for (Map.Entry<VehicleType, Integer> entry : vehicleTypeToCountMap.entrySet()) {
				ParkingSpacePOJO parkingSpacePOJO = new ParkingSpacePOJO();
				sb.append("\n" + entry.getKey() + "--> " + parking_id + " " + (parking_id - 1 + entry.getValue()));
				for (int count = 0; count < entry.getValue(); count++) {
					parkingSpacePOJO.getEmptySpaces()
							.add(new ParkingSpace(building_id, f, entry.getKey(), parking_id, false));
					parking_id++;
				}
				parkMap.put(entry.getKey(), parkingSpacePOJO);
			}
			System.out.println(sb);
			parkingFloorsList.add(parkingFloor);
			parkingFloor.setParkingSpaceMap(parkMap);
		}
		building.setParkingFloorMap(parkingFloorsList);
		this.parkingLot.getBuilding_having_parking_floors().add(building);
	}

	public Long unparkVehicle(Ticket t) {
		t.getParkingSpace().setOccupied(false);
		String building_id = t.getParkingSpace().getBuilding_id();
		Building building = parkingLot.findBuildingbyBuildingID(building_id, parkingLot);
		building.getDashboard().update(t.getVehicle().getType(), false);
		LocalDateTime inTime = t.getInTime();
		LocalDateTime outTime = LocalDateTime.now();
		Long costComputation = costComputation(inTime, outTime, t.getVehicle().getType());
		return costComputation;
	}

	private Long costComputation(LocalDateTime inTime, LocalDateTime outTime, VehicleType type) {
		return (long) (type.getBaseCharge()
				+ (outTime.toEpochSecond(ZoneOffset.UTC) - inTime.toEpochSecond(ZoneOffset.UTC)) / 3600
						* type.getChargesPerHour());
	}

	public Ticket parkVehicle(String building_id, Vehicle vehicle) {
		System.out.println("Redundant Code . Please Ignore");
//		System.out.println("Finding Spot for " + vehicle.getRegistrationNumber() + " in Parking lot");
//		Building buildingbyBuildingID = this.parkingLot.findBuildingbyBuildingID(building_id, this.parkingLot);
//		Optional<ParkingSpace> ps = findSpace(buildingbyBuildingID, vehicle);
//		if (ps.isPresent()) {
//			Ticket ticket = new Ticket();
//			ticket.setParkingSpace(ps.get());
//			ticket.setVehicle(vehicle);
//			ticket.setInTime(LocalDateTime.now());
//			ticket.setTicket_id(String.join("_", ps.get().getBuilding_id(), String.valueOf(ps.get().getFloor_num()),
//					String.valueOf(ps.get().getParking_id()), vehicle.getRegistrationNumber()));
//			System.out.println("Ticket generated:" + ticket.getTicket_id());
//			return ticket;
//		}
//		throw new RuntimeException("No Spots available for " + vehicle.getType());
		return null;

	}

	private Optional<ParkingSpace> findSpace(Building building, Vehicle vehicle) {
		System.out.println("Redundant Code . Please Ignore");
//		List<ParkingFloor> parkingFloorMap = building.getParkingFloorMap();
//		for (ParkingFloor pf : parkingFloorMap) {
//			Map<VehicleType, ParkingSpacePOJO> parkingSpaceMap = pf.getParkingSpaceMap();
//			if (!parkingSpaceMap.get(vehicle.getType()).getEmptySpaces().isEmpty()) {
//				ParkingSpace parkingSpace = parkingSpaceMap.get(vehicle.getType()).getEmptySpaces().remove(0);
//				parkingSpace.setOccupied(true);
//				building.getDashboard().update(vehicle.getType(), true);
//				parkingSpaceMap.get(vehicle.getType()).getOccupiedSpaces().add(parkingSpace);
//				return Optional.of(parkingSpace);
//			}
//		}
//		return Optional.empty();
		return null;
	}

}
