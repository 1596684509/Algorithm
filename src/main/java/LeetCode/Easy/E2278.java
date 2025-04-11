package LeetCode.Easy;

public class E2278 {

    public static void main(String[] args) {
        System.out.println(new E2278().percentageLetter("foobar", 'o'));
    }

    /**
     * 线性遍历，统计字母出现的次数，然后计算百分比
     * @param s
     * @param letter
     * @return
     */
    public int percentageLetter(String s, char letter) {

        double count = 0;
        for (char c : s.toCharArray()) {

            if(c == letter) {

                count++;

            }

        }

        return (int)(count / s.length() * 100);

    }

}
