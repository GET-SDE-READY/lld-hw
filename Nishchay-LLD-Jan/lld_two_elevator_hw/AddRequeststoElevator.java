package LLD_JAN_HW.lld_two_elevator_hw;

public class AddRequeststoElevator implements Runnable {

	private Elevator elevator;
	private Request request;

//	public AddRequeststoElevator(Elevator elevator, Request request) {
//		this.elevator = elevator;
//		this.request = request;
//	}

	public AddRequeststoElevator(Elevator e, Request request) {

		this.elevator = e;
		this.request = request;
	}

	@Override
	public void run() {
		delay();
		elevator.addRequests(request);

	}

	private void delay() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

//elevator.addRequests(request);
//if (request.getExternalRequest().getPrefDirection() == elevator1.getCurrentDirection()
//		&& request.getExternalRequest().getPrefDirection() == elevator2.getCurrentDirection()) {
//	if (elevator2.getCurr_floor() > elevator1.getCurr_floor()) {
//		if (request.getExternalRequest().getSourceFloor() < elevator2.getCurr_floor()
//				&& request.getExternalRequest().getSourceFloor() > elevator1.getCurr_floor()) {
//			elevator1.addRequests(request);
//		} else {
//			elevator2.addRequests(request);
//		}
//
//	} else {
//		if (request.getExternalRequest().getSourceFloor() < elevator1.getCurr_floor()
//				&& request.getExternalRequest().getSourceFloor() > elevator2.getCurr_floor()) {
//			elevator2.addRequests(request);
//		} else {
//			elevator1.addRequests(request);
//		}
//
//	}
//
//} else if (request.getExternalRequest().getPrefDirection() == elevator1.getCurrentDirection()) {
//	elevator1.addRequests(request);
//} else if (request.getExternalRequest().getPrefDirection() == elevator2.getCurrentDirection()) {
//	elevator2.addRequests(request);
//} else {
//
//}
//if (elevator1.getCurrentState() == State.IDLE && elevator2.getCurrentState() == State.IDLE) {
//	if (elevator1.getCurr_floor() == elevator2.getCurr_floor()) {
//		if (request.getExternalRequest().getPrefDirection() == elevator1.getCurrentDirection()
//				&& request.getExternalRequest().getPrefDirection() == elevator2.getCurrentDirection()) {
//			elevator1.addRequests(request);// preference to e1
//
//		} else if (request.getExternalRequest().getPrefDirection() == elevator1.getCurrentDirection()) {
//			// logic
//
//			if (request.getExternalRequest().getPrefDirection() == Direction.UP) {
//				if (request.getExternalRequest().getSourceFloor() > elevator1.getCurr_floor()) {
//					elevator1.addRequests(request);
//				} else {
//					elevator2.addRequests(request);
//				}
//			} else {
//				if (request.getExternalRequest().getSourceFloor() < elevator1.getCurr_floor()) {
//					elevator1.addRequests(request);
//				} else {
//					elevator2.addRequests(request);
//				}
//
//			}
//		} else if (request.getExternalRequest().getPrefDirection() == elevator2.getCurrentDirection()) {
//			// logic
//			if (request.getExternalRequest().getPrefDirection() == Direction.UP) {
//				if (request.getExternalRequest().getSourceFloor() > elevator2.getCurr_floor()) {
//					elevator2.addRequests(request);
//				} else {
//					elevator1.addRequests(request);
//				}
//			} else {
//				if (request.getExternalRequest().getSourceFloor() < elevator2.getCurr_floor()) {
//					elevator2.addRequests(request);
//				} else {
//					elevator1.addRequests(request);
//				}
//			}
//
//		} else {
//			elevator1.addRequests(request);// prefernce to e1
//		}
//	}
//}