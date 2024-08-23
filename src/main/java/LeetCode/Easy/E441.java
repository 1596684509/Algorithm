package LeetCode.Easy;

public class E441 {

    /**
     * 二次平方根公式求解
     * n = (Math.sqrt(1+8k) - 1) / 2
     */
    public E441(){}

    public int arrangeCoins(int n) {

        return (int) ((Math.sqrt(1 + 8 * (long) n) - 1) / 2);

    }

}
