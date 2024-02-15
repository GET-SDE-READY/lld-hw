package LLD_JAN_HW.parking_lot_hw.Strategy;

import java.util.Optional;

import LLD_JAN_HW.parking_lot_hw.models.Building;
import LLD_JAN_HW.parking_lot_hw.models.ParkingSpace;
import LLD_JAN_HW.parking_lot_hw.models.Vehicle;

public interface EntranceGateStrategy {

	Optional<ParkingSpace> findSpace(Building building, Vehicle vehicle);
}
