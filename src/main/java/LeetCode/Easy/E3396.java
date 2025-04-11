package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E3396 {

    /**
     * 通过哈希表和倒序遍历的方式，找到第一个重复的数后，计算最小操作次数
     * 优化：哈希表换成Set，速度快了整整1ms。
     * 再次优化：因为题目中最大的数字为100，因此可以创建一个大小为101的boolean数组替代set，速度更快。
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        int index = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            if(set.contains(nums[i])) {
                index = i + 1;
                break;
            }else {
                set.add(nums[i]);
            }

        }


        return index % 3 == 0 ? index / 3 : index / 3 + 1;


    }

}
