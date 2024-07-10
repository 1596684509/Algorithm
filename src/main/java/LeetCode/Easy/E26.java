package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;

public class E26 {

    /**
     * 遍历对比
     * 遇到重复的直接将后继元素补上
     */
    public E26() {
    }

    public static void main(String[] args) {
        int[] ins = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 5, 6, 8};

        removeDuplicates(ins);

    }

    public static int removeDuplicates(int[] nums) {
        int slowIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[slowIndex]!=nums[i]){
                nums[++slowIndex]=nums[i];
            }
        }
        return ++slowIndex;
    }

}
