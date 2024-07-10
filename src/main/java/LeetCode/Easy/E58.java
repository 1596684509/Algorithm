package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;

public class E58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello world end   length    "));
    }

    public static int lengthOfLastWord(String s) {

        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = chars.length - 1; i >= 0 ; i--) {

            if(chars[i] != ' ') {

                length++;

            }else if(length != 0) {

                break;

            }

        }

        return length;

    }

}
