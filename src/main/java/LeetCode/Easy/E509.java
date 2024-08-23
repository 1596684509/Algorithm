package LeetCode.Easy;

public class E509 {

    public int fib(int n) {

        double d = Math.sqrt(5);
        return (int) Math.round(Math.pow((1 + d) / 2, n) / d);

    }

}
