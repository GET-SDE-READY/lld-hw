package SorterAndShuffler;

import java.util.Random;

public class ShufflerOperation implements Operation {

	@Override
	public int[] execute(int[] nums) {
		System.out.println("Shuffling Operation");
		Random r = new Random();
		for (int i = 0; i < nums.length; i++) {
			int ri = r.nextInt(nums.length);
			int temp = nums[ri];
			nums[ri] = nums[i];
			nums[i] = temp;
		}
		return nums;
	}

}
