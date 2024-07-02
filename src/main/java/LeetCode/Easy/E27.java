package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;

import javax.print.DocFlavor;
import java.util.EnumSet;

public class E27 {

    public static void main(String[] args) {

        int[] ins = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(ins, 2));
        for (int i = 0; i < ins.length; i++) {


            System.out.print(ins[i] + " ");

        }

    }

    public static int removeElement(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[count] != val) {

                count++;

            }else {

                if(nums[i] != val) {

                    nums[count++] = nums[i];
                    nums[i] = val;
                    i = count;

                }

            }

        }

        return count;

    }

}
