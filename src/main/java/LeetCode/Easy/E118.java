package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class E118 {

    @Test
    public void t() {

        for (List<Integer> list : new E118().generate(5)) {

            for (Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println("");

        }

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);

        list.add(first);

        for (int i = 1; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {

                int v = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                row.add(v);

            }

            row.add(1);
            list.add(row);

        }

        return list;

    }

}
