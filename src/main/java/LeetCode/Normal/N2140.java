package LeetCode.Normal;

public class N2140 {

    public long mostPoints(int[][] questions) {

        int length = questions.length;
        //第几题
        int dp[] = new int[length];
        dp[length - 1] = questions[length - 1][0];

        for(int i = length - 3; i >= 0; i--) {

            int nextPoint = i + questions[i][1] >= length ? 0 : dp[i + questions[i][1]];

            dp[i] = Math.max((questions[i][0] + nextPoint), dp[i + 1]);

        }

        return dp[0];

    }

}
