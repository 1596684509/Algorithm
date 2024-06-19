package Algorithm;

public class BubbleSort {

    /*
    * 冒泡排序
    */
    public BubbleSort() {
    }

    public static void sort(int[] list) {

        sort(list, list.length - 1);

    }

    private static void sort(int[] list, int j) {

        if(j == 0) {

            return;

        }

        for (int i = 0; i < j; i++) {

            if(list[i] > list[i+1]) {

                int a = list[i+1];
                list[i + 1] = list[i];
                list[i] = a;

            }

        }

        sort(list, --j);

    }

}
