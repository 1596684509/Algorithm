package LeetCode.Easy;

public class E495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int result = duration;
        for (int i = 0; i < timeSeries.length -1 ; i++) {

            result += Math.min(timeSeries[i + 1] - timeSeries[i], duration);

        }

        return result;

    }

}
