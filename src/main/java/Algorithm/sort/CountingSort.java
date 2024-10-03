package Algorithm.sort;

public class CountingSort {

    /**
     * 计数排序
     * 创建一个新数组 大小为 max - min + 1
     * 遍历目标数组，对每个元素与 min 相减 得出对应下标
     * 新数组对应下标 + 1 （计数操作）
     * 对新数组进行遍历即可得到排序后的数组
     */
    public CountingSort() {
    }

    public void sort(int[] ins) {

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

}
