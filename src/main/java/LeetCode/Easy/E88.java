package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.List;

public class E88 {

    @Test
    public void t1() {

        int[] i1 = new int[]{2, 0};
        int[] i2 = new int[]{1};

        merge(i1, 1, i2, 1);

        for (int i : i1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;

        while(j >= 0) {

            if(i < 0 || nums2[j] > nums1[i]) {

                nums1[k--] = nums2[j--];

            }else {

                nums1[k--] = nums1[i--];

            }

        }

    }

}
