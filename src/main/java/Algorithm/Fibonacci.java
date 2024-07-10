package Algorithm;

import java.util.HashMap;

public class Fibonacci {

    private HashMap<Integer, Long> intmps = new HashMap<>();

    /**
     * 斐波那契数列
     */
    public Fibonacci() {

    }

    /**
     * 递归求解
     * @param x
     * @return
     */
    public long fibonacci(int x) {

        if(x == 0 || x == 1) {

            return x;

        }else if(intmps.containsKey(x)) {

            return intmps.get(x);

        }

        long i = fibonacci(x - 2);
        long y = fibonacci(x - 1);
        long he = i + y;
        intmps.put(x, he);
        return he;

    }

    /**
     * 公式求解
     * F(n) ≈ round( ((1+sqrt(5)) / 2)的 n 次方 / sqrt(5) )
     * sqrt(5) 为黄金分割
     * n = 第几位
     */
    public long fibonacci2(int x) {

        double d = Math.sqrt(5);
        return Math.round(Math.pow((1 + d) / 2, x) / d);

    }

}
