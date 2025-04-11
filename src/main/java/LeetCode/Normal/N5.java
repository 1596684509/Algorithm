package LeetCode.Normal;

public class N5 {

    /**
     * 中心扩展法
     * 将字符串自左向右遍历，假设每个字符为回文中心，分别处理回文为奇数和偶数的情况
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }

        int left = 0;
        int maxLen = 1;

        for (int i = 0; i < c.length; i++) {

            for (int j = 0; j < 2; j++) {

                int l = i;
                int r = i + j;

                while(l >= 0 && r < c.length && c[l] == c[r]) {

                    l--;
                    r++;

                }

                l++;
                r--;

                ///更新最大回文的长度和起始位置
                if(r - l + 1 > maxLen){
                    maxLen = r - l + 1;
                    left = l;
                }

            }

        }

        return s.substring(left, left + maxLen);

    }


}

