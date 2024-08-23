package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int[][] result = new int[r][c];
        int row = mat.length;
        int column = mat.length > 0 ? mat[0].length : 0;
        int count = row * column;
        
        if((r * c) != row * column ) {
            
            return mat;
            
        }
        for (int i = 0; i < count; i++) {
            result[i/c][i%c] = mat[i/column][i%column];
        }

        return result;

    }

}
