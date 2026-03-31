package leetcodeAndPrectice;

public class MaximumSubarray {
	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.print("max-subarray: " + maxSubArray(nums));

	}

	public static int maxSubArray(int[] nums) {
		int maxs = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > maxs) {
				maxs = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxs;
	}
}