package LeetCode.Easy;

public class E693 {

    public boolean hasAlternatingBits(int n) {

        char[] chars = Integer.toBinaryString(n).toCharArray();

        int c = -1;
        for (char aChar : chars) {

            if(c == aChar) {
                return false;
            }else {
                c = aChar;
            }

        }

        return true;

    }

    public boolean hasAlternatingBitsOther(int n) {

        int m = n ^ (n >> 1);
        return (m & (m + 1) ) == 0;

    }

}
