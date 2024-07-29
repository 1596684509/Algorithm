package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E338 {

    /**
     * 判断是否为2次幂
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * 判断奇偶数
     * @param n
     * @return
     */
    public int[] countBitsOther1(int n) {

        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0) {

                bits[i] = bits[i / 2];

            }else {

                bits[i] = bits[i-1] + 1;

            }
        }
        return bits;

    }

}
