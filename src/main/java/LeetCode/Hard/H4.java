package LeetCode.Hard;

import org.junit.jupiter.api.Test;

public class H4 {

    @Test
    public void t() {

        int[] array1 = {10, 20, 30, 40, 50};
        int[] array2 = {-5, 0, 7, -2, 14};

        System.out.print(findMedianSortedArrays(array1, array2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merge = new int[nums1.length + nums2.length];

        int x = 0;
        int y = 0;

        for (int i = 0; i < merge.length; i++) {

            if((y >= nums2.length) || (x < nums1.length && nums1[x] < nums2[y])) {

                merge[i] = nums1[x++];

            }else {

                merge[i] = nums2[y++];

            }

        }

        int midIndex = merge.length / 2;

        if((merge.length & 1) == 0) {

            int i = merge[midIndex];
            int j = merge[midIndex - 1];

            return (double)(i + j) / 2;

        }else {

            return merge[midIndex];

        }

    }

}
