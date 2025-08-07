package LLD_JAN_HW.lld_two_elevator_hw;

import java.util.TreeSet;

public class Elevator {

	private int curr_floor = 0;
	private Direction currentDirection = Direction.UP;
	private State currentState = State.IDLE;

	private static TreeSet<Request> currentRequests = new TreeSet<>();
	private static TreeSet<Request> upPendingRequests = new TreeSet<>();
	private static TreeSet<Request> downPendingRequests = new TreeSet<>();

	public void startElevator() {

		while (true) {
			if (checkReq()) {
				if (currentDirection == Direction.UP) {
					Request req = currentRequests.pollFirst();
					processUpRequest(req);
					if (currentRequests.isEmpty()) {
//						System.out.println(downPendingRequests);
						addDownPendingJobstoCurrentJobs();
//						System.out.println("))" + currentRequests);
					}

				} else {
					Request req = currentRequests.pollLast();
					processDownRequest(req);
					if (currentRequests.isEmpty()) {
						addUpPendingJobsToCurrenTJobs();
					}

				}
			} else {
				System.out.println("NO REQUESTS");
				delay();
			}

		}

	}

	private void addDownPendingJobstoCurrentJobs() {

		if (!downPendingRequests.isEmpty()) {
//			System.out.println("b4" + currentRequests);
			currentRequests = downPendingRequests;
//			System.out.println("af" + currentRequests);
			currentDirection = Direction.DOWN;
		} else {
			currentState = State.IDLE;
		}

	}

	private void addUpPendingJobsToCurrenTJobs() {

		if (!upPendingRequests.isEmpty()) {
			currentRequests = upPendingRequests;
			currentDirection = Direction.UP;
		} else {
			currentState = State.IDLE;
		}
	}

	private void processUpRequest(Request req) {
		int flag = 0;
		int startFloor = curr_floor;
		if (startFloor < req.getExternalRequest().getSourceFloor()) {
			for (int i = startFloor; i <= req.getExternalRequest().getSourceFloor(); i++) {
				delay();
				curr_floor = i;
				System.out.println("Elevating to " + curr_floor + "th floor");
				for (Request r : currentRequests) {
					if (i == r.getExternalRequest().getSourceFloor()) {
						System.out.println("Passenger entering into source floor " + curr_floor + "Thread: "
								+ Thread.currentThread().getName());
					}
				}
				if (checkIfNewJobCanBeProcessed(req, curr_floor)) {
					System.out.println("--Processing NEW REQUEST before reching to source floor--");
					flag = 1;
					break;
				}
				if (curr_floor == req.getExternalRequest().getSourceFloor()) {
					System.out.println("Passenger entering into source floor " + curr_floor + "Thread: "
							+ Thread.currentThread().getName());
				}

			}
		}
		if (flag == 0) {
			startFloor = curr_floor;
			for (int i = startFloor; i <= req.getInternalRequest().getDestinationfloor(); i++) {
				delay();
				System.out.println("Elevating to " + i + "th floor");
				curr_floor = i;
				for (Request r : currentRequests) {
					if (i == r.getExternalRequest().getSourceFloor()) {
						System.out.println("Passenger entering into source floor " + curr_floor + "Thread: "
								+ Thread.currentThread().getName());
					}
				}
				if (checkIfNewJobCanBeProcessed(req, curr_floor)) {
					System.out.println("--Processing NEW REQUEST before reching to destination floor--");
					break;
				}
				if (curr_floor == req.getInternalRequest().getDestinationfloor()) {
					System.out.println("Passenger leaving into destination floor " + curr_floor + "Thread: "
							+ Thread.currentThread().getName());
				}
			}

		}

	}

	private boolean checkIfNewJobCanBeProcessed(Request processingReq, int curr_floor) {
		if (checkReq()) {
			if (currentDirection == Direction.UP) {
				Request newReq = currentRequests.pollFirst();
				if (curr_floor < newReq.getExternalRequest().getSourceFloor() && (newReq.getInternalRequest()
						.getDestinationfloor() < processingReq.getInternalRequest().getDestinationfloor())) {
					currentRequests.add(newReq);
					currentRequests.add(processingReq);
					return true;
				}
				currentRequests.add(newReq);
			}
			if (currentDirection == Direction.DOWN) {
				Request newReq = currentRequests.pollLast();
				if (newReq.getInternalRequest().getDestinationfloor() > processingReq.getInternalRequest()
						.getDestinationfloor()) {
					currentRequests.add(newReq);
					currentRequests.add(processingReq);
					return true;
				}
				currentRequests.add(newReq);
			}

		}

		return false;
	}

	private void processDownRequest(Request req) {
		int flag = 0;
		int startFloor = curr_floor;
		if (startFloor > req.getExternalRequest().getSourceFloor()) {
			for (int i = startFloor; i >= req.getExternalRequest().getSourceFloor(); i--) {
				delay();
				curr_floor = i;
				System.out.println("Going Down to " + curr_floor + "th floor");

				for (Request r : currentRequests) {
					if (i == r.getExternalRequest().getSourceFloor()) {
						System.out.println("Passenger entering into source floor " + curr_floor + "Thread: "
								+ Thread.currentThread().getName());
					}
				}
				if (checkIfNewJobCanBeProcessed(req, curr_floor)) {
					System.out.println("--Processing NEW REQUEST before reching to source floor--" + "Thread: "
							+ Thread.currentThread().getName());
					flag = 1;
					break;
				}
				if (curr_floor == req.getExternalRequest().getSourceFloor()) {
					System.out.println("Passenger entering into source floor " + curr_floor + "Thread: "
							+ Thread.currentThread().getName());
				}

			}
		}
		if (flag == 0) {
			startFloor = curr_floor;
			for (int i = startFloor; i >= req.getInternalRequest().getDestinationfloor(); i--) {
				delay();
				System.out.println("Going down to " + i + "th floor");
				curr_floor = i;
				for (Request r : currentRequests) {
					if (i == r.getExternalRequest().getSourceFloor()) {
						System.out.println("Passenger entering into source floor " + curr_floor + "Thread: "
								+ Thread.currentThread().getName());
					}
				}
				if (checkIfNewJobCanBeProcessed(req, curr_floor)) {
					System.out.println("--Processing NEW REQUEST before reching to destination floor--");
					break;
				}
				if (curr_floor == req.getInternalRequest().getDestinationfloor()) {
					System.out.println("Passenger leaving into destination floor " + curr_floor + "Thread: "
							+ Thread.currentThread().getName());
				}
			}

		}

	}

	private boolean checkReq() {
		if (currentRequests.isEmpty()) {
			return false;
		}
		return true;
	}

	public void addRequests(Request request) {
		System.out.println("NEW REQUEST " + "SRC:" + request.getExternalRequest().getSourceFloor() + " DES:"
				+ request.getInternalRequest().getDestinationfloor() + " Direction:"
				+ request.getExternalRequest().getPrefDirection());
		if (currentState == State.IDLE) {
			currentState = State.MOVE;
			currentDirection = request.getExternalRequest().getPrefDirection();
			currentRequests.add(request);
		} else if (currentState == State.MOVE) {
			if (currentDirection != request.getExternalRequest().getPrefDirection()) {
				addPendingJobs(request);
			} else {
				if (currentDirection == Direction.UP
						&& curr_floor > request.getInternalRequest().getDestinationfloor()) {
					addPendingJobs(request);
				} else if (currentDirection == Direction.DOWN
						&& curr_floor < request.getInternalRequest().getDestinationfloor()) {
					addPendingJobs(request);
				} else {
					currentRequests.add(request);
				}

			}

		}

	}

	private void addPendingJobs(Request request) {
		if (request.getExternalRequest().getPrefDirection() == Direction.DOWN) {
			addDownPendingJobs(request);
		} else {
			addUpPendingJobs(request);
		}
	}

	private void addDownPendingJobs(Request request) {

		downPendingRequests.add(request);

	}

	private void addUpPendingJobs(Request request) {

		upPendingRequests.add(request);

	}

	private void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCurr_floor() {
		return curr_floor;
	}

	public void setCurr_floor(int curr_floor) {
		this.curr_floor = curr_floor;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

}
