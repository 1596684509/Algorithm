package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E674 {

    @Test
    public void t() {

        findLengthOfLCIS(new int[]{1,3,5,7});

    }

    public int findLengthOfLCIS(int[] nums) {

        int max = 0;
        int size = 0;

        if(nums.length == 1) {
            return 1;
        }

        for (int i = 1; i < nums.length; i++) {

            if(nums[i - 1] < nums[i]) {

                size++;

            }else {

                max = Math.max(max, size);
                size = 0;

            }

            if(i == nums.length - 1) {

                max = Math.max(max, size);

            }

        }

        return max + 1;

    }

}
