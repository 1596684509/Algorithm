package LeetCode.Easy;

public class E507 {

    /**
     * 目前位置小于 int 范围内的完美数只有 6 个，直接打表
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        switch(num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }

}
