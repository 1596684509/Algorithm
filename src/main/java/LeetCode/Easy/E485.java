package LeetCode.Easy;

public class E485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int left = 0;
        int right = left;
        int max = 0;

        while(left < nums.length && right < nums.length) {

            if(nums[left] == 1) {
                right = left + 1;
                while(right < nums.length && nums[right] == 1) {

                    right++;

                }

                max = Math.max(max, right - left);
                left = right;

            }else {

                left++;

            }

        }

        return max;

    }

}
