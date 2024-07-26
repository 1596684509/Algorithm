package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E169 {

    @Test
    public void t() {

        System.out.println(majorityElement(new int[]{1,3, 2, 2, 2, 2, 2, 5 ,6 ,7 ,8 , 8,}));

    }

    public int majorityElement(int[] nums) {

        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;

    }

}
