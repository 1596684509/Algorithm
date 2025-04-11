package LeetCode.Normal;

import java.util.Arrays;

public class N416 {

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        if (n < 2) {

            return false;

        }
        int sum = 0;

        for (int num : nums) {

            sum += num;

        }

        if(sum % 2 == 1) {
            return false;
        }

        boolean[] dp = new boolean[n];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 0; i < n; i++) {

            for (int j = sum / 2; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }

        }

        return dp[sum / 2];


    }

}
