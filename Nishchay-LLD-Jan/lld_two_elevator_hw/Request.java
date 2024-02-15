package LLD_JAN_HW.lld_two_elevator_hw;

public class Request implements Comparable<Request> {

	private InternalRequest internalRequest;
	private ExternalRequest externalRequest;

	public Request(InternalRequest internalRequest, ExternalRequest externalRequest) {
		super();
		this.internalRequest = internalRequest;
		this.externalRequest = externalRequest;
	}

	public InternalRequest getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(InternalRequest internalRequest) {
		this.internalRequest = internalRequest;
	}

	public ExternalRequest getExternalRequest() {
		return externalRequest;
	}

	public void setExternalRequest(ExternalRequest externalRequest) {
		this.externalRequest = externalRequest;
	}

	@Override
	public int compareTo(Request req) {

		if (this.getInternalRequest().getDestinationfloor() == req.getInternalRequest().getDestinationfloor())
			return 0;
		else if (this.getInternalRequest().getDestinationfloor() > req.getInternalRequest().getDestinationfloor())
			return 1;
		else
			return -1;
	}

}
