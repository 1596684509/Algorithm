package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E171 {

    @Test
    public void t() {

        System.out.println(titleToNumber("AZ"));

    }

    public int titleToNumber(String columnTitle) {
        int value = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int charValue = columnTitle.charAt(i) - 'A' + 1;
            value = value * 26 + charValue;
        }
        return value;
    }

}
