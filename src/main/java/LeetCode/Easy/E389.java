package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.lang.management.MemoryType;
import java.util.HashSet;
import java.util.Set;

public class E389 {

    @Test
    public void t() {



    }

    public char findTheDifference(String s, String t) {

        int i = 0;
        int x = 0;
        for (int i1 = 0; i1 < s.length(); i1++) {

            i += s.charAt(i1);

        }

        for (int i1 = 0; i1 < t.length(); i1++) {

            x += t.charAt(i1);

        }

        return (char) (x - i);

    }

    public char findTheDifferenceOfter1(String s, String t) {

        int x = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {

            x ^= s.charAt(i) ^ t.charAt(i);

        }

        x ^= t.charAt(length);
        return (char) x;

    }



}
