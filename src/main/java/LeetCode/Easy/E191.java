package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E191 {

    @Test
    public void t() {

        System.out.println(Integer.toBinaryString(65));
        System.out.println(Integer.toBinaryString(hammingWeight(65)));

    }

    public int hammingWeight(int n) {

        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;

    }

}
