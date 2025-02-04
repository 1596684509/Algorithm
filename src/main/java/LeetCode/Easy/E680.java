package LeetCode.Easy;

import java.util.Stack;

public class E680 {

    public boolean validPalindrome(String s) {

        return valid(s, 0, s.length()-1, false);

    }

    private boolean valid(String s,  int i, int j, boolean isDeep) {

        while(i < j) {

            char a = s.charAt(i);
            char b = s.charAt(j);

            if(a != b) {

                if(isDeep) {

                    return false;

                }

                return valid(s, i++, j, true) || valid(s, i, j--, true);

            }

            i++;
            j--;

        }

        return true;

    }

}
