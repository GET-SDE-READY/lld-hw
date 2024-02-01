package SorterAndShuffler;

import java.util.ArrayList;
import java.util.List;

public class OperationsExecutor {

	public static final List<Operation> operationslist = new ArrayList<>();

	public int[] executeOperation(Operation op, int[] nums) {
		operationslist.add(op);
		return op.execute(nums);
	}

}
