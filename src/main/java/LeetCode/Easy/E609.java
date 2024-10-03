package LeetCode.Easy;

public class E609 {

    public String toLowerCase(String s) {

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if(charArray[i] >= 'A' && charArray[i] <= 'Z') {
                charArray[i] = (char) (charArray[i] + 32);
            }

        }

        return String.valueOf(charArray);

    }

}
