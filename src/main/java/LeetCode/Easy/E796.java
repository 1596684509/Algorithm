package LeetCode.Easy;

public class E796 {

    /**
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {

        return s.length() == goal.length() && (s + s).contains(goal);

    }

}
