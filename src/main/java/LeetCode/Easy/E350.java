package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        int size = 1002;
        int[] nCount1 = new int[size];
        int[] nCount2 = new int[size];

        for (int i : nums1) {
            nCount1[i]++;
        }

        int index = 0;
        for (int i : nums2) {
            if(nCount1[i] > 0) {

                nCount2[index++] = i;
                nCount1[i]--;

            }
        }



        return Arrays.copyOf(nCount2, index);

    }



}
