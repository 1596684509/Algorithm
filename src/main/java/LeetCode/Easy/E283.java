package LeetCode.Easy;

public class E283 {

    public void moveZeroes(int[] nums) {
        int s=0;//定义收集不是0的数的指针
        //开始收集不是零的数
        for (int i = 0; i < nums.length ;i++) {
            if(nums[i]!=0){
                nums[s++] = nums[i];
            }
        }
        //收集完毕后,后面自然就都是0了
        for (int i = s; i < nums.length; i++) {
            nums[i]=0;
        }
    }

}
