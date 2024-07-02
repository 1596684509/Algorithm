package LeetCode.Easy;

import java.lang.reflect.Parameter;

public class E28 {

    public int strStr(String haystack, String needle) {

        KMP kmp = new KMP(haystack, needle);
        return kmp.getIndex();

    }

    static class KMP {

        private String objString;
        private String pattern;
        private int[] next;

        public KMP(String objString, String pattern) {
            this.objString = objString;
            this.pattern = pattern;
        }

        private void createNext() {

            int length = pattern.length();
            next = new int[length];
            int j = 0;
            next[0] = j;

            for (int i = 1; i < length; i++) {

                while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {

                    j = next[j - 1];

                }

                if(pattern.charAt(i) == pattern.charAt(j)) {

                    j++;

                }
                next[i] = j;

            }

        }

        public int getIndex() {

            createNext();
            int index = 0;
            for (int i = 0; i < objString.length(); i++) {

                while(index > 0 && pattern.charAt(index) != objString.charAt(i)) {

                    index = next[index - 1];

                }

                if(pattern.charAt(index) == objString.charAt(i)) {

                    index++;

                }

                if(index == pattern.length()) {

                    return i - pattern.length() + 1;

                }

            }

            return -1;

        }

        public int[] getNext() {
            return next;
        }
    }
}
