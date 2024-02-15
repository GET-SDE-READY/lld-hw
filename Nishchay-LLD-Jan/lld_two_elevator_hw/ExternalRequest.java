package LLD_JAN_HW.lld_two_elevator_hw;

public class ExternalRequest {

	private Direction prefDirection;
	private int sourceFloor;

	public ExternalRequest(Direction prefDirection, int sourceFloor) {
		super();
		this.prefDirection = prefDirection;
		this.sourceFloor = sourceFloor;
	}

	public Direction getPrefDirection() {
		return prefDirection;
	}

	public void setPrefDirection(Direction prefDirection) {
		this.prefDirection = prefDirection;
	}

	public int getSourceFloor() {
		return sourceFloor;
	}

	public void setSourceFloor(int sourceFloor) {
		this.sourceFloor = sourceFloor;
	}

}
