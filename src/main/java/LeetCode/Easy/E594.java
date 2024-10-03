package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.awt.image.BandedSampleModel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E594 {

    @Test
    public void t() {

        findLHS(new int[] {1,3,2,2,5,2,3,7});

    }

    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0)+1);

        }

        for (Integer i : map.keySet()) {

            int x = map.get(i);
            if(map.containsKey(i + 1)) {

                result = Math.max(result, x + map.get(i + 1));

            }

        }

        return result;

    }

}
