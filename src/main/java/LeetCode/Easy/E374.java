package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class E374 {

    @Test
    public void t() {

        Assertions.assertEquals(0, guess(80));

    }

    public int guessNumber(int n) {

        int left = 0;
        int right = Math.min(n * 2, Integer.MAX_VALUE);
        int mid = n;
        int result = guess(mid);
        while(result != 0) {

            if(result == -1) {

                right = mid - 1;

            }else {

                left = mid + 1;

            }

            mid = (right - left) / 2 + left;
            result = guess(mid);

        }

        return mid;

    }

    private int guess(int num) {

        int i = 100;
        int j = 0;

        if(num > i) {

            j--;

        }else if(num < i) {

            j++;

        }

        return j;

    }

}
