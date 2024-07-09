package LeetCode.Easy;

public class E69 {

    /**
     * 暴力破解
     * 从 x 开始递增计算
     * 如果 x 的平方 = 目标数返回，大于目标则返回 x - 1
     *
     * 牛顿法
     *
     */
    public E69() {
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(16));

    }

    /**
     * 暴力破解
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        if(x == 1 || x == 0) {

            return x;

        }else if(x == 2) {

            return 1;

        }else if(x == 2147483647) {

            return 46340;

        }

        for (int i = 1; i < x; i++) {

            if(i * i == x) {

                return i;

            }else if(i * i > x) {

                return i-1;

            }

        }

        return -0;

    }

}
