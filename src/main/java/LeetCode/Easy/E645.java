package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class E645 {

    @Test
    public void t() {

        findErrorNums(new int[] {9, 8, 1,3,2,4, 4, 6, 7,});

    }

    public int[] findErrorNums(int[] nums) {

        int[] result = new int[2];
        //排序查重
        for (int i = 0; i < nums.length; i++) {

            while(nums[i] != i+1) {

                int ind = nums[i] - 1;
                if(nums[ind] == nums[i]) {

                    result[0] = nums[ind];
                    break;

                }

                swap(nums, i, ind);

            }

        }

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] != i + 1) {

                result[1] = i + 1;
                break;

            }

        }

        return result;
        
    }

    private void swap(int[] nums, int i , int j) {

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

    }

}
