package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E697 {

    @Test
    public void t() {

        Assertions.assertEquals(2, findShortestSubArrayOther(new int[]{1,2,2,3,1,4,2}));

    }

    /**
     * 先统计最多的数量
     * 在统计长度最小的
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {

            max = Math.max(max, num);
            min = Math.min(min, num);

        }

        int[] count = new int[max - min + 1];

        int degree = 0;
        for (int num : nums) {

            degree = Math.max(degree, ++count[num - min]);

        }

        if(degree == 1) {
            return 1;
        }

        int result = nums.length;

        for (int i = 0; i < count.length; i++) {

            if(degree != count[i]) {
                continue;
            }

            int tmp = i + min;
            int strat = 0;
            int end = nums.length - 1;
            while(strat < end && nums[strat] != tmp) {
                strat++;
            }
            while(end > strat && nums[end] != tmp) {
                end--;
            }

            result = Math.min(result,end - strat + 1);

        }

        return result;

    }

    public int findShortestSubArrayOther(int[] nums) {
        // 找到数组中的最小数和最大数
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        // 使用计数排序的思想
        //求最大多少个数字
        int[] count = new int[max - min + 1];
        // 记录出现最高的次数是多少次数
        int degree = 0;
        for (int i : nums) {
            degree = Math.max(degree, ++count[i - min]);
        }
        // 如果数组的度为 1，则结果必为 1
        if (degree == 1) {
            return 1;
        }
        int result = nums.length;
        for (int i = 0; i < count.length; i++) {
            if (degree != count[i]) {
                continue;
            }
            // 还原原数的值
            int tmp = min + i;
            // 求该数出现的起始和结束的下标
            int start = 0, end = nums.length - 1;
            while (start < end && tmp != nums[start]) {
                start++;
            }
            while (start < end && tmp != nums[end]) {
                end--;
            }
            result = Math.min(result, end - start + 1);
        }
        return result;
    }

}
