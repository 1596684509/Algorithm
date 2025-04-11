package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class E771 {

    /**
     * 遍历jewels，将其加入set中，然后遍历stones，如果stones中的字符在set中，则result++
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {

        int result = 0;
        Set<Character> set = new HashSet<Character>();

        for (char c : jewels.toCharArray()) {

            set.add(c);

        }

        for (char c : stones.toCharArray()) {

            if(set.contains(c)) {

                result++;

            }

        }

        return result;

    }

    /**
     * 优化，使用数组代替set，节省空间同时提升效率
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones2(String jewels, String stones) {

        int result = 0;

        boolean[] jewelsArray = new boolean[123];

        for (char c : jewels.toCharArray()) {
            jewelsArray[c] = true;
        }

        for (char c : stones.toCharArray()) {

            if(jewelsArray[c]) {
                result++;
            }

        }

        return result;

    }



}
