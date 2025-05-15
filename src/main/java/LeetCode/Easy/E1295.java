package LeetCode.Easy;

public class E1295 {

    public static void main(String[] args) {
        System.out.println(new E1295().numberSize(-10));

    }

    /**
     * 1.直接转文字获取长度
     * 2.将数整除10计算位数
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {

        int result = 0;

        for (int num : nums) {

            if((numberSize(num) & 1) == 0) {

                result++;

            }

        }

        return result;

    }

    public int numberSize(int x) {

        int d = 1;

        if(x >= 0) {

            d = 0;
            x = -x;

        }

        int p = -10;
        for (int i = 1; i < 10; i++) {

            if(x > p) {

                return i + d;

            }

            p *= 10;

        }

        return 10 + d;

    }

}
