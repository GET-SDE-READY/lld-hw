package LLD_JAN_HW.parking_lot_hw.Strategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;
import LLD_JAN_HW.parking_lot_hw.models.Building;
import LLD_JAN_HW.parking_lot_hw.models.ParkingFloor;
import LLD_JAN_HW.parking_lot_hw.models.ParkingSpace;
import LLD_JAN_HW.parking_lot_hw.models.ParkingSpacePOJO;
import LLD_JAN_HW.parking_lot_hw.models.Vehicle;

public class EntranceGateStrategyUtil {

	public static Optional<ParkingSpace> findSpaceUtil(Building building, Vehicle vehicle, int flag) {
		List<ParkingFloor> parkingFloorMap = building.getParkingFloorMap();
		for (ParkingFloor pf : parkingFloorMap) {
			Map<VehicleType, ParkingSpacePOJO> parkingSpaceMap = pf.getParkingSpaceMap();
			if (!parkingSpaceMap.get(vehicle.getType()).getEmptySpaces().isEmpty()) {
				List<ParkingSpace> emptySpaces = parkingSpaceMap.get(vehicle.getType()).getEmptySpaces();
				ParkingSpace parkingSpace = null;
				if (flag == 1) {
					// BackendGate
					parkingSpace = emptySpaces.remove(emptySpaces.size() - 1);
				} else if (flag == 0) {
					// FrontendGate
					parkingSpace = emptySpaces.remove(0);
				}
				parkingSpace.setOccupied(true);
				building.getDashboard().update(vehicle.getType(), true);
				parkingSpaceMap.get(vehicle.getType()).getOccupiedSpaces().add(parkingSpace);
				return Optional.of(parkingSpace);
			}
		}
		return Optional.empty();
	}

}
