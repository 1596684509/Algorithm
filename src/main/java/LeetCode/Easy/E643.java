package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E643 {

    @Test
    public void t() {

        findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4);

    }

    public double findMaxAverage(int[] nums, int k) {

        // 滑动窗口
        // 题目给出长度为k，保持双指针之间的长度固定

        int sum = 0;
        int n = nums.length;
        // 计算第一个窗口，以后的窗口只在这个窗口上减去一个旧的，添加一个新的
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        // 用第一个窗口的和初始化max
        int maxSum = sum;
        // 以后的窗口从k开始
        for(int i = k; i < n; i++){
            // 用第一个（上一个）窗口的和减去最后一个值，然后新增一个值，就是下一个窗口
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

}
