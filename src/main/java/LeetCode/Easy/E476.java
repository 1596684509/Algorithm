package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class E476 {

    @Test
    public void t() {

        findComplementOther1(33);

    }

    public int findComplement(int num) {

        String base2Str = Integer.toBinaryString(num);
        char[] charsBase2 = base2Str.toCharArray();

        for (int length = charsBase2.length - 1; length >= 0; length--) {

            charsBase2[length] = (char) (charsBase2[length] - '0' == 1 ? '0' : '1');

        }

        base2Str = new String(charsBase2);
        return Integer.parseInt(base2Str, 2);

    }

    /**
     * 将一个数的二进制与等位全是1的数进行相减即可求出其补数
     * 如 base10 = 5 base2 = 101
     * 111 - 101 = 010
     * @param num
     * @return
     */
    public int findComplementOther1(int num) {

        int cp = num;
        //将所有位置变为1；
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;

        return num - cp;

    }

}
