package LeetCode.Easy;

public class E766 {

    /**
     * 比较排除掉每行的最后一个元素和最后一行，将剩下的元素错位比较。
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {

        //行
        for (int i = 0; i < matrix.length; i++) {

            if(i == matrix.length - 1) {
                return true;
            }

            //第 1 ~ 到倒数第二个列
            for (int j = 0; j < matrix[i].length - 1; j++) {

                if(matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }

            }

        }

        return true;

    }

}
