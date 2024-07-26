package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class E231 {

    @Test
    public void t() {

        Assertions.assertEquals(true, isPowerOfTwo(3));

    }

    public boolean isPowerOfTwo(int n) {

        if(n <= 0) {

            return false;

        }

        int i = (n-1) & n;

        return i == 0;


    }


    private int reverse(int i) {

        i = (i & 0x55555555) << 1 | (i >> 1) & 0x55555555;
        if ((i & 1) == 1) return i;
        i = (i & 0x33333333) << 2 | (i >> 2) & 0x33333333;
        if ((i & 1) == 1) return i;
        i = (i & 0x0f0f0f0f) << 4 | (i >> 4) & 0x0f0f0f0f;
        if ((i & 1) == 1) return i;
        i = (i & 0x00ff00ff) << 8 | (i >> 8) & 0x00ff00ff;
        if ((i & 1) == 1) return i;
        i = (i & 0x0000ffff) << 16 | (i >> 16) & 0x0000ffff;
        if ((i & 1) == 1) return i;

        return i;

    }

}
