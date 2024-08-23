package LeetCode.Easy;

public class E392 {

    public boolean isSubsequence(String s, String t) {

        if(s == null) {

            return true;

        }

        int x = 0;
        int y = 0;

        while(x < s.length() && y < t.length()) {

            if(s.charAt(x) == t.charAt(y++)) {

                x++;

            }

        }

        return x == s.length();

    }

}
