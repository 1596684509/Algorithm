package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class E202 {

    private HashSet<Integer> hashSet = new HashSet<>();

    @Test
    public void t() {

        Assertions.assertEquals(true, isHappy(19));

    }

    private int getNext(int n) {

        int i = 0;

        while(n > 0) {

            i += (int) Math.pow(n % 10, 2);
            n /= 10;

        }

        return i;

    }

    public boolean isHappy(int n) {

        while(n != 1 && !hashSet.contains(n)) {

            hashSet.add(n);
            n = getNext(n);

        }

        return n == 1;

    }

}
