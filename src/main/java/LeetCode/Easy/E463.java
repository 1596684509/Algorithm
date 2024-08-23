package LeetCode.Easy;

public class E463 {

    public int islandPerimeter(int[][] grid) {

        int result = 0;

        //遍历行
        for (int i = 0; i < grid.length; i++) {

            //遍历列
            for (int j = 0; j < grid[i].length; j++) {

                if(grid[i][j] == 1) {

                    result += 4;
                    if(i > 0 && grid[i - 1] [j] == 1) {

                        result -= 2;

                    }

                    if(j > 0 && grid[i][j - 1] == 1) {

                        result -= 2;

                    }

                }

            }

        }

        return result;

    }

}
