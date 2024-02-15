package LLD_JAN_HW.lld_two_elevator_hw;

public class ElevatorThread implements Runnable {

	Elevator elevator;

	public ElevatorThread(Elevator elevator) {
		// TODO Auto-generated constructor stub
		this.elevator = elevator;
	}

	@Override
	public void run() {
		elevator.startElevator();
	}

}
