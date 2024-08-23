package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class E409 {

    @Test
    public void t() {

       System.out.print( longestPalindrome("AAAaaa"));

    }

    public int longestPalindrome(String s) {

        char[] cs = s.toCharArray();

        int[] counts = new int[52];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            int index = -1;
            if(cs[i] >= 'a') {

                index = cs[i] - 'a';

            }else {

                index = cs[i] - 'A' + 26;

            }

            counts[index]++;

        }

        for (int i = 0; i < counts.length; i++) {

            count += counts[i] / 2 * 2;

            if(counts[i] % 2 == 1 && (count & 1) == 0) {

                count++;

            }

        }

        return count;

    }

}
