package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E168 {

    /**
     * 将数转为 26 进制 对应字母 26 个字符
     * 因为 A 对应 1 所以 需要将目标 -1 后进行计算
     * 将目标数 除 26 求余后与 'A' 相加即可求出对应字符
     * 后将目标数 除 26 缩小计算范围
     * 插入字符串第一位(从低到高计算)
     * 如 目标数 27
     * 27 - 1 = 26
     * 26 / 26 ... 0
     * 'A' + 0 = A
     * A 插入字符串头
     * 26 / 26 = 1
     * 1 - 1 = 0
     * 0 / 26 ... 0
     * 'A' + 0 = A
     * A 插入字符串头
     * 所以 27 = AA
     */
    public E168() {

    }

    @Test
    public void t() {

        System.out.println(base26(702));

    }

    public String convertToTitle(int columnNumber) {

        return base26(columnNumber);

    }

    public String base26(int num) {

        StringBuilder sb = new StringBuilder();
        while(num > 0) {

            num--;
            char c = (char)('A' + num % 26);
            num /= 26;
            sb.insert(0, c);

        }

        return sb.toString();

    }

}
