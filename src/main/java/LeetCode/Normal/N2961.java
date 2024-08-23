package LeetCode.Normal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N2961 {

    @Test
    public void t() {

        getGoodIndices(new int[][] {{31,12,21,24}}, 1);

    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new LinkedList();
        for (int i = 0; i < variables.length; i++) {
            if (goodArray(variables[i], target)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean goodArray(int[] arr, int target) {
        int a = arr[0], b = arr[1], c = arr[2], m = arr[3];
        return power(power(a, b, 10), c, m) == target;
    }

    public int power(int a, int b, int c) {
        int result = 1;
        a = a % c;  // Handle the case when a is larger than c
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % c;
            }
            a = (a * a) % c;
            b = b / 2;
        }
        return result;
    }

}
