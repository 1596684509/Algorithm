package LeetCode.Easy;


public class E67 {

    /**
     * 从后往前进行遍历
     * 有字符则将字符与 '0' 相减
     * 没有则为0
     * 将得到的数相加求2的余数
     * 在将得到的数相加除2求接下来的进数
     *
     * char 类型 -'0' 转 int
     * 假设现有字符 '8' 对应 ASCII 56
     * 而字符 '0' 对应 ASCII 48
     * 将字符相减 即 56-48 = 8
     * 因此能将字符转为数字
     *
     */
    public E67() {
    }

    public static void main(String[] args) {
        System.out.println(addBinary("10010", "11000"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder ans = new StringBuilder();
        int ca = 0;

        for (int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {

            int su = ca;
            su += i >= 0 ? a.charAt(i) - '0' : 0;
            su += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(su % 2);
            ca = su / 2;

        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();

    }


}
