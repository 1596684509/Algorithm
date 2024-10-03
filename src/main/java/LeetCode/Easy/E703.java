package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class E703 {

    private int k;
    private int[] results;

    /**
     * 先通过计数排序对数组进行排序，
     * 提取其中最大的 k 位数保存到结果数组
     * 维护结果数组
     * 性能较低
     *
     * 使用并维护小顶堆。
     * 性能较高
     * @param k
     * @param nums
     */
    public E703(int k, int[] nums) {

        this.k = k;
        results = new int[k];
        for (int i1 = 0; i1 < results.length; i1++) {
            results[i1] = Integer.MIN_VALUE;
        }

        countingSort(nums);

        for (int numsI = nums.length - 1, resultsI = results.length - 1; numsI >= 0 && resultsI >= 0; numsI--) {

            results[resultsI] = nums[numsI];
            resultsI--;

        }


    }

    public void countingSort(int[] ins) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int in : ins) {
            max = Math.max(max, in);
            min = Math.min(min, in);
        }

        int[] sorteds = new int[max - min + 1];

        for (int in : ins) {

            sorteds[in - min]++;

        }

        int insI = 0;
        for (int i = 0; i < sorteds.length; i++) {

            while(sorteds[i] != 0) {

                int tmp = i + min;
                ins[insI] = tmp;
                insI++;
                sorteds[i]--;

            }

        }

    }

    public int add(int val) {
        // 插入新元素到results数组
        int left = 0, right = results.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (results[mid] == val) {
                left = mid; // 新元素与现有元素相同
                break;
            } else if (results[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 如果新元素大于results中的最小值，进行插入
        if (left > 0) {
            // 左移更新
            for (int i = 0; i < left - 1; i++) {
                results[i] = results[i + 1];
            }
            results[left - 1] = val;  // 插入新值
        }

        // 返回最小值（第k大元素）
        return results[0];
    }

}
