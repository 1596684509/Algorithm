package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E190 {

    @Test
    public void t() {

        reverseBits(15);

    }

    public int reverseBits(int n) {

        n = (n & 0x55555555) << 1 | (n >> 1) & 0x55555555;
        n = (n & 0x33333333) << 2 | (n >> 2) & 0x33333333;
        n = (n & 0x0f0f0f0f) << 4 | (n >> 4) & 0x0f0f0f0f;
        n = (n & 0x00ff00ff) << 8 | (n >> 8) & 0x00ff00ff;
        n = (n & 0x0000ffff) << 16 | (n >> 16) & 0x0000ffff;

        return n;

    }

}
