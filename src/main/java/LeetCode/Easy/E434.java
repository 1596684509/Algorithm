package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E434 {

    @Test
    public void t() {

        countSegments("Hello, my name is John");

    }

    public int countSegments(String s) {
        String []s1 = s.split(" ");
        int res =0;
        for(String s2 : s1){
            if(s2.length()>0)
                res++;
        }
        return res;
    }

}
