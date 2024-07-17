package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E136 {

    @Test
    public void t() {

        int[] is = new int[] {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(singleNumber(is));

    }

    public int singleNumber(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            nums[0] ^= nums[i];

        }

        return nums[0];

    }

}
