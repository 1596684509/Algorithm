package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E557 {


    @Test
    public void t() {

        reverseWords("Let's take LeetCode contest");

    }

    public String reverseWords(String s) {

        char[] cs = s.toCharArray();
        int l = 0;
        for (int i = 0; i < cs.length; i++) {

            if(cs[i] == ' ') {

                reverse(cs, l, i - 1);
                l = i + 1;

            }

        }

        reverse(cs, l, s.length()-1);
        return String.valueOf(cs);

    }

    public void reverse(char[] cs, int l, int r) {

        while(l < r) {

            cs[l] ^= cs[r];
            cs[r] ^= cs[l];
            cs[l] ^= cs[r];

            r--;
            l++;

        }

    }

}
