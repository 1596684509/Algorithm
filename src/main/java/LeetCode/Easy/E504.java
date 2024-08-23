package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E504 {

    @Test
    public void t() {

        convertToBase7(-100);

    }

    public String convertToBase7(int num) {

        boolean b = num < 0;

        if(b) {
            num = -num;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while(num / 7 != 0) {

            stringBuilder.append(num % 7);
            num /= 7;

        }

        stringBuilder.append(b ? num + "-" : num);

        return stringBuilder.reverse().toString();

    }



}
