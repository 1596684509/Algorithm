package LeetCode.Easy;

import java.util.Arrays;

public class E628 {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int r1 = nums[0] * nums[1] * nums[nums.length - 1];
        int r2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return Math.max(r1, r2);

    }

}
