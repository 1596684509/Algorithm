package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class E349 {

    @Test
    public void t() {

        intersection(new int[]{4, 9, 5}, new int[]{9,4,9,8,4});

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> commonNumSet = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                commonNumSet.add(num);
            }
        }
        return commonNumSet.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] intersectionOther1(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        for(int x : nums1){
            cnt[x]++;
        }
        int count = 0;
        for(int x : nums2){
            if(cnt[x] > 0){
                temp[count++] = x;
                cnt[x] = 0;
            }
        }
        int[] res = new int[count];
        System.arraycopy(temp, 0,  res, 0, count);
        return res;
    }

}
