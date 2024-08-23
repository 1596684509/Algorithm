package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class E482 {

    @Test
    public void t() {

        licenseKeyFormatting("5F3Z-2e-9-w", 4);

    }

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {

            if(c != '-') {

                if(c >= 'a') {

                    c = (char) (c - 32);

                }

                stringBuilder.append(c);

            }

        }

        char[] cs = stringBuilder.toString().toCharArray();
        int addIndex = stringBuilder.length() % k == 0 ? k - 1 : stringBuilder.length() % k - 1;
        stringBuilder = new StringBuilder();

        for (int i = 0; i < cs.length; i++) {

            stringBuilder.append(cs[i]);
            if(i == addIndex && i != cs.length-1) {

                stringBuilder.append('-');
                addIndex += k;
            }

        }


        return stringBuilder.toString();

    }

}
