package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class E733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];
        dfs(image, sr, sc, color, oldColor);
        return image;

    }

    public void dfs(int[][] image, int x, int y, int newColor, int oldColor) {

        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }

        if(image[x][y] != oldColor || image[x][y] == newColor) {
            return;
        }

        image[x][y] = newColor;

        dfs(image, x - 1, y, newColor, oldColor);
        dfs(image, x + 1, y, newColor, oldColor);
        dfs(image, x, y - 1, newColor, oldColor);
        dfs(image, x , y + 1, newColor, oldColor);

    }

}
