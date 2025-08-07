package SorterAndShuffler;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		int[] nums = { 6, 5, 6, 2, 3, 1 };
		OperationsExecutor ope1 = new OperationsExecutor();
		int[] opsort1 = ope1.executeOperation(new SorterOperation(new Descending()), nums);
		Arrays.stream(opsort1).forEach(e -> System.out.print(e + " "));
		System.out.println("----------");
		OperationsExecutor ope2 = new OperationsExecutor();
		int[] opsort2 = ope2.executeOperation(new SorterOperation(new Ascending()), nums);
		Arrays.stream(opsort2).forEach(e -> System.out.print(e + " "));
		System.out.println("-----------");
		OperationsExecutor ope3 = new OperationsExecutor();
		int[] opshuffle = ope3.executeOperation(new ShufflerOperation(), nums);
		Arrays.stream(opshuffle).forEach(e -> System.out.print(e + " "));
		System.out.println(OperationsExecutor.operationslist);

	}

}
