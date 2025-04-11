import Algorithm.Sample;
import DataStructure.Tree.RedBlackTree;
import LeetCode.Easy.E70;
import LeetCode.Easy.E83;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestMain {


    public static void main(String[] args) {


        long tag = 1;

        int[] nums = {1, 0, 0, 1, 0, 1, 0 , 0, 0, 0, 1};

        for (int num : nums) {

            tag <<= 1;

            if(num == 1) {

                tag++;

            }



        }

        System.out.println(Long.toBinaryString(tag));



    }


}
