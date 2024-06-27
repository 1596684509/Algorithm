package LeetCode.Easy;

import java.util.Stack;

public class E20 {

    public static boolean isValid(String s) {

        Stack<Character> linkedList = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);


            if(c1 == '(' || c1 == '[' || c1 == '{') {

                linkedList.push(c1);

            }else {

                if(linkedList.isEmpty() || !isCombinction(linkedList.pop(), c1)) {

                    return false;

                }

            }

        }

        if(linkedList.isEmpty()) {

            return true;

        }

        return false;

    }

    private static boolean isCombinction(char c1, char c2) {

        if(c1 == '(' && c2 == ')') {
            return true;
        }

        if(c1 == '[' && c2 == ']') {
            return true;
        }

        if(c1 == '{' && c2 == '}') {
            return true;
        }
        return false;
    }

}
