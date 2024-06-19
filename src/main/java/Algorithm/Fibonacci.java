package Algorithm;

import java.util.HashMap;

public class Fibonacci {

    private HashMap<Integer, Long> intmps = new HashMap<>();

    /**
     * 斐波那契数列
     */
    public Fibonacci() {

    }

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

}
