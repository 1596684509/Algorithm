package LeetCode.Normal;

import java.util.Arrays;
import java.util.Comparator;

public class N3111 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {

        Arrays.sort(points, Comparator.comparing(o -> o[0]));

        int x = -1;
        int count = 0;

        for (int[] point : points) {

            if(point[0] > x) {

                count++;
                x = point[0] + w;

            }

        }

        return count;

    }

}
