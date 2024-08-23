package Algorithm;

import org.junit.jupiter.api.Test;

public class FastExponentiation {

    /**
     * 快速幂算法
     * 将指数进行二分拆除后运算
     * 假设 计算 10的6 次幂
     * 10 * 10 * 10 * 10 * 10 * 10
     * 等价于
     * pow(10,2) * pow(10,2) * pow(10,2) = 100 * 100 * 100
     * 也可以等等价于
     * pow(10,4) * pow(10,2) = 10000 * 100
     *
     * 指数拆分
     * 设指数为41
     * pow(n, 41) = pow(n,32) * pow(n,8) * pow(n,1)
     * 转为二进制
     * 41 = 101001
     * 32 = 100000
     * 8  = 001000
     * 1  = 000001
     * 可以得出结论
     * 将底数进行逐步递增 （n = n * n）
     * 指数逐步递减 (41 / 2) 向下取整
     * 如果指数二进制末尾为1
     * 即可与结果相乘
     */
    public FastExponentiation() {}

    @Test
    public void t() {

        System.out.print(power(15, 5));

    }

    public long power(long base, long exp) {

        long result = 1;

        while(exp != 0) {

            //指数的二进制末尾是否为1
            if((exp & 1) == 1) {

                result = result * base;

            }

            //此处处理结果 (例子)10 * 10 * 10 * 10 -> 100 * 100
            //对底数进行递增
            base = base * base;
            //对指数进行缩减
            exp = exp >>> 1;

        }

        return result;

    }

}
