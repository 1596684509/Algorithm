package LeetCode.Easy;

public class E459 {


    /**
     * 如果一个字符串是由字串拼接而成
     * 那么将字串数量翻倍后破坏掉头和尾，剩余部分一定包含翻倍前的字符串
     * 如 abcabcabc 由 abc 组成
     * 对其翻倍 abcabcabcabcabcabc
     * 破坏头尾 bcabcabcabcabcab
     * 与字符串比较
     * bc (abcabcabc) abcab
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {

        return (s + s).substring(1, 2 + s.length()-1).contains(s);

    }

}
