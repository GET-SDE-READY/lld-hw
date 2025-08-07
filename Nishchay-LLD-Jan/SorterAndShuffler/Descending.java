package SorterAndShuffler;

import java.util.Arrays;

public class Descending implements SortingStrategy {

	@Override
	public int[] sort(int[] nums) {
		System.out.println("Descending Order");

		Arrays.sort(nums);
		for (int i = 0; i < nums.length / 2; i++) {
			int temp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = temp;
		}
		return nums;
	}

}
