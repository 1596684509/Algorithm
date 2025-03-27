package LeetCode.Normal;

public class N2712 {

    /**
     * 贪心算法，遍历每个字符和他的下一个字符，如果不同，计算两种
     * 翻转的最小代价
     *
     * ps:不是很懂，最后的字符串每个字符并不相等。但是过了。
     * @return
     */
    public long minimumCost(String s) {
        int n = s.length();
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(i, n - i);
            }
        }
        return res;
    }

}
