package LLD_JAN_HW.parking_lot_hw.enums;

public enum VehicleType {
	CAR(50, 20), BIKE(30, 10), TRUCK(100, 30);

	private int baseCharge;
	private int chargesPerHour;

	private VehicleType(int baseCharge, int chargesPerHour) {
		this.baseCharge = baseCharge;
		this.chargesPerHour = chargesPerHour;
	}

	public int getBaseCharge() {
		return baseCharge;
	}

	public int getChargesPerHour() {
		return chargesPerHour;
	}

}
