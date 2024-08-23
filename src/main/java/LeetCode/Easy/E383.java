package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class E383 {

    @Test
    public void t() {

        canConstruct("aa", "aab");

    }

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {

            hashMap.put(magazine.charAt(i), hashMap.getOrDefault(magazine.charAt(i), 0) + 1);

        }

        for (int i = 0; i < ransomNote.length(); i++) {

            hashMap.put(ransomNote.charAt(i), hashMap.getOrDefault(ransomNote.charAt(i), 0) - 1);
            if(hashMap.get(ransomNote.charAt(i)) == null || hashMap.get(ransomNote.charAt(i)) < 0) {

                return false;

            }

        }

        return true;

    }

    public boolean canConstructOther1(String ransomNote, String magazine) {

        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {

            count[magazine.charAt(i) - 'a']++;

        }

        for (int i = 0; i < ransomNote.length(); i++) {

            if(count[ransomNote.charAt(i) - 'a'] == 0) {

                return false;

            }

            count[ransomNote.charAt(i) - 'a']--;

        }

        return true;

    }

}
