package Algorithm;

import org.junit.jupiter.api.Test;

public class YangHuiSanJiao {

    /**
     * 杨辉三角
     */
    public YangHuiSanJiao() {
    }


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

    public void printN(int n, int i) {

        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {

            System.out.print(" ");

        }

    }

}
