package LeetCode.Easy;

public class E806 {

    public int[] numberOfLines(int[] widths, String s) {
        int lastSum = 0;
        int lines = 1;

        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (lastSum + width > 100) {
                lines++;
                lastSum = width;
            } else {
                lastSum += width;
            }
        }

        return new int[]{lines, lastSum};
    }

}
