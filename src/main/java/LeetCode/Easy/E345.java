package LeetCode.Easy;

public class E345 {

    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        char[] cs = s.toCharArray();

        while(i < j) {

            while(i < j && !isVowel(cs[i])) {

                i++;

            }

            while (j > 0 && !isVowel(cs[j])) {

                j--;

            }

            if(i < j) {

                cs[i] ^= cs[j];
                cs[j] ^= cs[i];
                cs[i] ^= cs[j];

                i++;
                j--;

            }

        }

        return new String(cs);

    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

}
