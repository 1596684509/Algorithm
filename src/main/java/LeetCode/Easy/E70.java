package LeetCode.Easy;

public class E70 {

    public int climbStairs(int n) {

        return (int) new Fibonacci().getValue(n);

    }

    class Fibonacci {

        public double getValue(int i) {

            double goldenRatio = Math.sqrt(5);
            double v = (1 + goldenRatio) / 2;

            return  Math.round(Math.pow(v, i + 1) / goldenRatio);

        }

    }

}
