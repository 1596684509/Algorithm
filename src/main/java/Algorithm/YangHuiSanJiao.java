package Algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class YangHuiSanJiao {

    /**
     * 杨辉三角
     */
    public YangHuiSanJiao() {
    }

    /**
     * 公式求行
     * @param rowIndex 第几行
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }


    /**
     * 递归求值
     * @param i 行
     * @param j 位
     * @return
     */
    public int getNum(int i, int j) {

        if(j == 0 || i == j) {

            return 1;

        }

        return getNum(i - 1, j - 1) + getNum(i - 1, j);

    }

    public void print(int height) {

        for (int i = 0; i < height; i++) {

            printN(height, i);

            for (int j = 0; j <= i ; j++) {

                System.out.printf("%4d", getNum(i, j));

            }

            System.out.println("");

        }

    }

    /**
     * 输出空格
     * @param n
     * @param i
     */
    public void printN(int n, int i) {

        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {

            System.out.print(" ");

        }

    }

}
