package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E344 {

    @Test
    public void t() {

        char[] chars = "abcdefgh".toCharArray();
        reverseStringOther1(chars);

        for (int i = 0; i < chars.length; i++) {

            System.out.print(chars[i]);

        }

    }

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {

            char c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;

        }

    }

    /**
     * s[i] ^= s[j] = a ^ b;
     * s[j] ^= s[i] = a ^ b ^ b = a ^ 0 = a
     * s[i] ^= s[j] = a ^ b ^ a = 0 ^ b = b
     * @param s
     */
    public void reverseStringOther1(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {

            int j = s.length - i  - 1;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];

        }

    }

}
