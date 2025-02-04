package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class E728 {

    @Test
    public void t() {

        selfDividingNumbers(1, 22);

    }

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        for (int range = left; range <= right; range++) {

            if(check(range)) {

                list.add(range);

            }

        }

        return list;

    }

    private boolean check(int i) {

        int temp = i;

        while(temp != 0) {

            int j = temp % 10;
            if(j == 0 || i % j != 0) {
                return false;
            }

            temp /= 10;

        }

        return true;

    }

}
