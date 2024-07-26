package LeetCode.Easy;

public class E326 {

    public boolean isPowerOfThree(int n) {

        String s = Integer.toString(n, 3);

        return s.matches("^10*$");

    }

}
