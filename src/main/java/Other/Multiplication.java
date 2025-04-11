package Other;

public class Multiplication {

    /**
     * 将乘法变成加法进行计算
     * 通过检测b的二进制最后一位是否为1来判断
     * 如果为1，则将乘数加入结果。
     * 然后将b右移一位，进行迭代，同时为了保持数据不变，a左移一位。
     * @param a
     * @param b
     * @return
     */
    public int multiply(int a, int b) {

        int result = 0;
        while (b != 0) {

            if((b & 1) == 1) {

                result += a;

            }

            b >>= 1;
            a <<= 1;

        }

        return result;

    }

}
