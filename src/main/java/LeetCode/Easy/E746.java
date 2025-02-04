package LeetCode.Easy;

import org.junit.jupiter.api.Test;

/**
 * 动态规划
 */
public class E746 {


    public int minCostClimbingStairs(int[] cost) {
        int costLength = cost.length;

        // 初始状态
        int prev2 = cost[0];
        int prev1 = cost[1];

        // 从第 2 阶开始遍历到最后一阶
        for (int i = 2; i < costLength; i++) {
            int curr = Math.min(prev1 + cost[i], prev2 + cost[i]);
            prev2 = prev1; // 更新 prev2 为上一个 prev1
            prev1 = curr;  // 更新 prev1 为当前计算结果
        }

        // 返回最后两阶中较小的总成本
        return Math.min(prev1, prev2);
    }

}
