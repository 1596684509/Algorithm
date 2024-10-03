package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class E682 {

    @Test
    public void t() {

        calPoints(new String[]{"5","-2","4","C","D","9","+","+"});

    }

    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int sum = 0, i = 0;
        for (String str : operations) {
            int val;
            if (str.equals("C")) {
                sum -= stack[-- i];
                continue;
            } else if (str.equals("D")) {
                val = stack[i - 1] << 1;
            } else if (str.equals("+")) {
                val = stack[i - 1] + stack[i - 2];
            } else {
                val = Integer.parseInt(str);
            }
            sum += val;
            stack[i ++] = val;
        }
        return sum;
    }


}
