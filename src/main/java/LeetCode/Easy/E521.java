package LeetCode.Easy;

public class E521 {

    /**
     * 什么sb东西
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {

        if(a.equals(b)) {

            return -1;

        }else {

            return Math.max(a.length(), b.length());

        }

    }

}
