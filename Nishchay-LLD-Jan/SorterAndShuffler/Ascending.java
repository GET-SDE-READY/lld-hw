package SorterAndShuffler;

import java.util.Arrays;

public class Ascending implements SortingStrategy {

	@Override
	public int[] sort(int[] nums) {
		System.out.println("Ascending");
		Arrays.sort(nums);
		return nums;
	}

}
