package LeetCode.Normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N2829 {


    /**
     * 首先 符合题目要求的数有两种情况
     * num >= k
     * a + b != k
     * 所以我们可以先生成一个array数组，和一个Set集合
     * 把a存入array，b存入Set集合
     * 然后从1开始遍历，如果a不在Set集合中，则把a存入array，b存入Set集合，count++
     * 当count等于n时，说明已经生成了n个符合条件的数，我们可以计算array的和，返回即可
     * 时间复杂度 O(n)
     *
     * 优化
     * 使用等差数列求和公式，可以直接计算出结果
     * 时间复杂度 O(1)
     * @param n
     * @param k
     * @return
     */
    public int minimumSum(int n, int k) {

        if(k / 2 >= n) {

            return arithmeticSeriesSum(1, 1, n);

        }else {

            return arithmeticSeriesSum(1, 1, k / 2) + arithmeticSeriesSum(k, 1, n - k / 2);

        }

    }

    public int arithmeticSeriesSum(int a, int d, int n) {

        return (2 * a + (n - 1) * d) * n / 2;

    }

    public static void main(String[] args) {
        String s = "123456789";
        System.out.println(s.substring(0, 5));
    }

}
