package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class E268 {

    /**
     * 运用异或的自反性
     * a ^ b ^ a = b; a 消除
     * 因为只会少一个数 所以只要对数组进行遍历
     * 将 i 和 nums[i] 进行消除，剩下的就是缺少的数字
     */
    public E268() {}

    @Test
    public void t() {

        int[] ints = new int[]{0,1,2,3,4,5,6,7,8,9,10,12,13,14,15};
        System.out.println(missingNumber(ints));

    }

    public int missingNumber(int[] nums) {

         int res = nums.length;
         for(int i = 0; i < nums.length; i++){
             res ^= nums[i] ^ i;
         }
         return res;

    }

}
