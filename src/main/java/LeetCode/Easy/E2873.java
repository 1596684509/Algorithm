package LeetCode.Easy;

public class E2873 {


    /**
     * 前后缀
     * 创建两个数组分别存储从左往右区间的最大值和从右往左区间的最大值
     * 遍历nums数组，完善两个数组
     * 再次遍历数组，计算每个位置的最大值
     * @param nums
     * @return
     */
    public long maximumTripletValue(int[] nums) {

        int length = nums.length;
        int pre[] = new int[nums.length];
        int back[] = new int[nums.length];

        pre[0] = nums[0];
        back[length-1] = nums[length-1];

        for (int i = 1; i < length; i++) {

            pre[i] = Math.max(pre[i-1], nums[i]);
            back[length-i-1] = Math.max(back[length-i], nums[length-i-1]);

        }

        long res = 0;

        for (int i = 1; i < length - 1; i++) {

            long l = (long) (pre[i - 1] - nums[i]) * back[i + 1];
            res = Math.max(res, l);

        }

        return res;

    }

}
