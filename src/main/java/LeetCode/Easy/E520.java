package LeetCode.Easy;

public class E520 {

    public static boolean detectCapitalUse(String word) {
        int upperCaseNum = 0;
        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                upperCaseNum++;
            }
        }
        return upperCaseNum == 0 || upperCaseNum == word.length() || (upperCaseNum == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }

}
