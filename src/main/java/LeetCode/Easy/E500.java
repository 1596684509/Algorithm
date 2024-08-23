package LeetCode.Easy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E500 {

    public String[] findWords(String[] words) {

        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";

        List<String> stringList = new ArrayList<>();

        for (String word : words) {

            int i1 = 0;
            int i2 = 0;
            int i3 = 0;

            for (int j = 0; j < word.length(); j++) {

                if(s1.contains(word.charAt(j) + "")) {
                    i1++;
                }else if(s2.contains(word.charAt(j) + "")) {
                    i2++;
                }else if(s3.contains(word.charAt(j) + "")) {
                    i3++;
                }

                if(i1 == word.length() || i2 == word.length() || i3 == word.length()) {

                    stringList.add(word);

                }

            }

        }

        return stringList.toArray(new String[]{});

    }

}
