package LeetCode.Easy;

public class E657 {

    public boolean judgeCircle(String moves) {

        int[] ins = new int[26];

        for (char c : moves.toCharArray()) {

            ins[c - 'A']++;


        }

        return ins['U' - 'A'] == ins['D' - 'A'] && ins['L' - 'A'] == ins['R' - 'A'];

    }


}
