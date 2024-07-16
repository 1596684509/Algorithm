package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class E119 {

    @Test
    public void t() {

        for (Integer i : new E119().getRow(13)) {

            System.out.print(i + " ");

        }

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

}
