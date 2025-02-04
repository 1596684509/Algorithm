package LeetCode.Easy;

import javax.xml.stream.XMLInputFactory;

public class E744 {

    public char nextGreatestLetter(char[] letters, char target) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < letters.length; i++) {

            if(letters[i] > target) {

                min = Math.min(letters[i], min);

            }

        }

        return min == Integer.MAX_VALUE ? letters[0] : (char) min;

    }

    public char nextGreatestLetterOfter(char[] letters, char target) {

        int l = 0;
        int r = letters.length - 1;

        while(l <= r) {

            int mid = l + ((r - l) >> 1);

            if(letters[mid] < target + 1) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }

        }

        return l == letters.length ? letters[0] : letters[l];

    }

}
