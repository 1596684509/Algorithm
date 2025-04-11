package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class E804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();

        StringBuilder sb = new StringBuilder();

        for (String word : words) {


            for (char c : word.toCharArray()) {

                sb.append(morse[c - 'a']);

            }

            set.add(sb.toString());
            sb.delete(0, sb.length());

        }

        return set.size();


    }

}
