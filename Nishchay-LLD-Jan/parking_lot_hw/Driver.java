package LLD_JAN_HW.parking_lot_hw;

import java.util.Map;

import LLD_JAN_HW.parking_lot_hw.Strategy.BackEndGateParkingStrategy;
import LLD_JAN_HW.parking_lot_hw.enums.VehicleType;
import LLD_JAN_HW.parking_lot_hw.models.EntranceGate;
import LLD_JAN_HW.parking_lot_hw.models.ParkingLot;
import LLD_JAN_HW.parking_lot_hw.models.Ticket;
import LLD_JAN_HW.parking_lot_hw.models.Vehicle;
import LLD_JAN_HW.parking_lot_hw.services.ParkingService;

public class Driver {

	public static void main(String[] args) {

		ParkingService parkingService = new ParkingService();
		parkingService.createParkingLot("b1", 1, Map.of(VehicleType.CAR, 4, VehicleType.BIKE, 6, VehicleType.TRUCK, 4));
		parkingService.createParkingLot("b2", 1,
				Map.of(VehicleType.CAR, 6, VehicleType.BIKE, 10, VehicleType.TRUCK, 4));
		ParkingLot parkingLot = parkingService.getParkingLot();
		parkingService.getParkingLot().findBuildingbyBuildingID("b1", parkingLot).getDashboard().display();
		parkingService.getParkingLot().findBuildingbyBuildingID("b2", parkingLot).getDashboard().display();
//		working(parkingService,parkingLot);
		Vehicle vehicle1 = new Vehicle("BR12034", VehicleType.CAR);
		EntranceGate feg = new EntranceGate(new BackEndGateParkingStrategy());
		Ticket parkVehicle1 = feg.parkVehicle("b2", vehicle1, parkingLot);
		parkingService.getParkingLot().findBuildingbyBuildingID("b1", parkingLot).getDashboard().display();
		parkingService.getParkingLot().findBuildingbyBuildingID("b2", parkingLot).getDashboard().display();
		Long totalcharges = parkingService.unparkVehicle(parkVehicle1);
		System.out.println(totalcharges);
		parkingService.getParkingLot().findBuildingbyBuildingID("b1", parkingLot).getDashboard().display();
		parkingService.getParkingLot().findBuildingbyBuildingID("b2", parkingLot).getDashboard().display();
		System.out.println("----");
	}

	static void working(ParkingService parkingService, ParkingLot parkingLot) {

//		Vehicle vehicle1 = new Vehicle("BR12034", VehicleType.CAR);
//		Vehicle vehicle2 = new Vehicle("BR12035", VehicleType.CAR);
//		Vehicle vehicle3 = new Vehicle("BR12036", VehicleType.BIKE);
//		Vehicle vehicle4 = new Vehicle("BR12037", VehicleType.TRUCK);
//		Vehicle vehicle5 = new Vehicle("BR12038", VehicleType.BIKE);
//		Ticket parkVehicle1 = parkingService.parkVehicle("b1", vehicle1);
//		Ticket parkVehicle2 = parkingService.parkVehicle("b1", vehicle2);
//		Ticket parkVehicle3 = parkingService.parkVehicle("b2", vehicle3);
//		Ticket parkVehicle4 = parkingService.parkVehicle("b2", vehicle4);
//		Ticket parkVehicle5 = parkingService.parkVehicle("b2", vehicle5);
//		parkingService.getParkingLot().findBuildingbyBuildingID("b1", parkingLot).getDashboard().display();
//		parkingService.getParkingLot().findBuildingbyBuildingID("b2", parkingLot).getDashboard().display();
//		Long totalcharges5 = parkingService.unparkVehicle(parkVehicle5);
//		System.out.println(totalcharges5);
//		System.out.println("----");
//		Long totalcharges4 = parkingService.unparkVehicle(parkVehicle4);
//		System.out.println(totalcharges4);
//		System.out.println("----");
//		parkingService.getParkingLot().findBuildingbyBuildingID("b1", parkingLot).getDashboard().display();
//		parkingService.getParkingLot().findBuildingbyBuildingID("b2", parkingLot).getDashboard().display();

	}

}
