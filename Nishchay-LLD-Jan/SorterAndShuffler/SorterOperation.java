package SorterAndShuffler;

public class SorterOperation implements Operation, SortingStrategy {

	private SortingStrategy sortingStrategy;

	public SorterOperation(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}

	@Override
	public int[] execute(int[] nums) {
		System.out.println("Sorter Operation");
		int[] sort = sort(nums);
		return sort;
	}

	@Override
	public int[] sort(int[] nums) {
		int[] sort = sortingStrategy.sort(nums);
		return sort;
	}

}
