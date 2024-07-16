package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E125 {

    @Test
    public void t() {

        System.out.println(isPalindrome("0P"));

    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            char lc = s.charAt(left);
            char rc = s.charAt(right);

            try {

                while(!isLetter(lc) || !isLetter(rc)) {

                    if(!isLetter(lc)) {

                        left++;
                        lc = s.charAt(left);

                    }

                    if(!isLetter(rc)) {

                        right--;
                        rc = s.charAt(right);

                    }


                }

            }catch (StringIndexOutOfBoundsException e) {

                return false;

            }

            if(lc != rc) {

                return false;

            }else {

                left++;
                right--;

            }

        }

        return true;

    }

    public boolean isLetter(char c) {

        if(c >= 97 && c <= 122) {

            return true;

        }

        return false;

    }
}
