package LeetCode.Easy;

public class E121 {

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {

            if(price < min) {

                min = price;

            }else if(price - min > max) {

                max = price - min;

            }

        }

        return max;

    }

}
