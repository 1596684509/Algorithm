package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.math.MathContext;

public class E405 {

    @Test
    public void t() {

        System.out.print(toHex(-1));

    }

    public String toHex(int _num) {

        long num = _num;

        if (num < 0) num = (long)(Math.pow(2, 32) + num);

        if(num == 0) {

            return "0";

        }

        StringBuilder stringBuilder = new StringBuilder();

        while(num > 0) {

            long i = num & 0x00000f;

            if(i > 9) {

                stringBuilder.append(toChar(i));

            }else {

                stringBuilder.append(i);

            }

            num = num >>> 4;

        }

        return stringBuilder.reverse().toString();

    }

    public char toChar(long num) {

        long i = num - 10;
        return (char) ('a' + i);

    }

}
