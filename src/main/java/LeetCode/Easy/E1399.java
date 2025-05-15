package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class E1399 {

    public static void main(String[] args) {

        if(true) {

            System.out.println("hello");

        }else if(true) {

            System.out.println("world");
        }

    }

    /**
     * 记忆搜索法，计算每个位数和后用map记录，同时记录最大值
     * 查找拥有相同值的个数
     * @param n
     * @return
     */
    public int countLargestGroup(int n) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount = 0;

        for (int i = 1; i <= n; i++) {

            int bitSum = bitSum(i);
            map.put(bitSum, map.getOrDefault(bitSum, 0) + 1);

            maxCount = Math.max(maxCount, map.get(bitSum));

        }

        int result = 0;
        for (Integer i : map.keySet()) {

            if(map.get(i) == maxCount) {
                result++;
            }

        }

        return result;

    }

    public int bitSum(int n) {

        int sum = 0;
        while( n > 0) {

            sum += n % 10;
            n /= 10;

        }

        return sum;

    }

}


