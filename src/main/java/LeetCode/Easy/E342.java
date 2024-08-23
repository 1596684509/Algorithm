package LeetCode.Easy;

public class E342 {

    /**
     * 转换为四进制后判断 是否为 1 * 10 的 n 次方
     * 效率较低
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {

        String string = Integer.toString(n, 4);
        return string.matches("^10*$");

    }

    /**
     * 因为 4次幂的数肯定也是2次幂， 且二进制中
     * 与2次幂一样只有一个1，并且只在奇数位
     * 因此在判定2次幂的基础上和 0x55555555 进行与运算(&) 后不为0;
     * @param n
     * @return
     */
    public boolean isPowerOfFourOther1(int n) {

        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;

    }

}
