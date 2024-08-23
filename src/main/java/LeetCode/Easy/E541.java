package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E541 {

    @Test
    public void t() {
        System.out.println(reverseStr("abcdefg", 4));  // 示例输出
        System.out.println(reverseStr("abcdefgh", 3)); // 其他测试
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();  // 将字符串转换为字符数组，便于修改

        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            // 注意计算右边界，避免越界
            int right = Math.min(i + k - 1, arr.length - 1);
            // 反转字符数组中的子数组
            while (left < right) {
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }

        return new String(arr);  // 将字符数组转换回字符串并返回
    }
}