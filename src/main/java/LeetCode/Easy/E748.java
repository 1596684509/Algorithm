package LeetCode.Easy;

public class E748 {


    public static void main(String[] args) {

        E748 e748 = new E748();

        System.out.println(e748.shortestCompletingWord("1s3 456", new String[]{"looks","pest","stew","show"}));

    }

    public String shortestCompletingWord(String licensePlate, String[] words) {

        String result = null;
        int[] metaCount = count(licensePlate);

        for (String word : words) {

            boolean isResult = true;

            int[] subCount = count(word);

            for (int i = 0; i < 26; i++) {

                if(metaCount[i] > 0 && metaCount[i] > subCount[i]) {

                    isResult = false;
                    break;

                }

            }

            if(isResult) {

                if(result == null || result.isEmpty()) {

                    result = word;

                }else {

                    result = result.length() <= word.length() ? result : word;

                }

            }

        }

        return result;

    }

    public int[] count(String s) {

        int[] count = new int[26];
        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            int letter = isLetter(c);

            if(letter == 0) {
                continue;
            }else if(letter == 1) {
                count[c - 'a']++;
            }else {
                count[c - 'A']++;
            }

        }

        return count;

    }

    /**
     * 检测c是否是字母
     * @param c
     * @return 0 不是字母 1 小写字母 2 大写字母
     */
    public int isLetter(char c) {

        if(c >= 'a' && c <= 'z') {
            return 1;
        }else if(c >= 'A' && c <= 'Z') {
            return 2;
        }else {
            return 0;
        }
    }

}
