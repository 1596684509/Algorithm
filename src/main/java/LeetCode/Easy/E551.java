package LeetCode.Easy;

public class E551 {

    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == 'A' || s.charAt(i) == 'P') {
                if(s.charAt(i) == 'A') {
                    a++;
                }
                l = 0;
            }else {
                l++;
            }

            if(a == 2 || l == 3) {

                return false;

            }

        }

        return true;

    }

}
