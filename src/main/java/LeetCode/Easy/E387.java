package LeetCode.Easy;

public class E387 {

    public int firstUniqChar(String s) {

        int min = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {

            int fi = s.indexOf(i);
            int li = s.lastIndexOf(i);

            if(fi != -1 && fi == li) {

                min = Math.min(fi, min);

            }

        }

        return min == Integer.MAX_VALUE? -1 : min;

    }

}
