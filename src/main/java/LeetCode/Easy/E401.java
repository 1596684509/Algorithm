package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class E401 {

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> strings = new ArrayList<>();

        for(int h = 0; h < 12; h++) {

            for (int m = 0; m < 60; m++) {

                if(Integer.bitCount(m) + Integer.bitCount(h) == turnedOn) {

                    strings.add(String.format("%d:%02d", h, m));

                }

            }

        }

        return strings;

    }

}
