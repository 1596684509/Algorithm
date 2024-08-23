package Algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RedixSort {

    @Test
    public void t() {

        sort(new int[]{2, 5, 6, 6, 7, 7, 7, 9, 10, 10});

    }

    /**
     * 基数排序
     */
    public RedixSort() {}

    public void sort(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1;

        while(max / exp > 0) {

            countingSort(arr, exp);
            exp *= 10;

        }

    }

    public void countingSort(int[] arr, int exp) {

        int length = arr.length;

        //输出
        int[] output = new int[length];
        //放0-9的数
        int[] base = new int[10];

        for (int i = 0; i < length; i++) {

            int index = (arr[i] / exp) % 10;
            base[index]++;

        }

        for (int i = 1; i < 10; i++) {

            base[i] += base[i-1];

        }

        for(int i = length - 1; i >= 0; i--) {

            int index = (arr[i] / exp) % 10;
            output[base[index] - 1] = arr[i];
            base[index]--;

        }

        System.arraycopy(output,0, arr,0, length);

    }

}
