package LLD_JAN_HW.lld_two_elevator_hw;

public class Main {
	public static void main(String[] args) {

		Elevator elevator1 = new Elevator();
		new Thread(new ElevatorThread(elevator1)).start();
		Request req1 = new Request(new InternalRequest(5), new ExternalRequest(Direction.UP, 1));
		new Thread(new AddRequeststoElevator(elevator1, req1)).start();
		delay(2500);
		Elevator elevator2 = new Elevator();
		new Thread(new ElevatorThread(elevator2)).start();
		Request req2 = new Request(new InternalRequest(9), new ExternalRequest(Direction.UP, 6));
		new Thread(new AddRequeststoElevator(elevator1, req2)).start();
		new Thread(new AddRequeststoElevator(elevator2, req2)).start();
		delay(10000);
		Request req3 = new Request(new InternalRequest(0), new ExternalRequest(Direction.DOWN, 8));
		new Thread(new AddRequeststoElevator(elevator1, req3)).start();
		new Thread(new AddRequeststoElevator(elevator2, req3)).start();
		delay(2500);
		Request req4 = new Request(new InternalRequest(3), new ExternalRequest(Direction.UP, 1));
		new Thread(new AddRequeststoElevator(elevator1, req4)).start();
		new Thread(new AddRequeststoElevator(elevator2, req4)).start();

	}

	private static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
