package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E303 {

    private int[] prefix;

    public void NumArray(int[] nums) {

        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {

            prefix[i + 1] = prefix[i] + nums[i];

        }

    }

    public int sumRange(int left, int right) {

        return prefix[right + 1] - prefix[left];

    }

    @Test
    public void t() {

        NumArray(new int[] {-2,0,3,-5,2,-1});

    }

}
