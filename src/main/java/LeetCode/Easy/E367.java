package LeetCode.Easy;

public class E367 {

    public boolean isPerfectSquare(int num) {

        int left = 0;
        int right = num;

        while(left <= right) {

            int mid = (right - left) / 2 + left;
            long result = (long) mid * mid;
            if(result > num) {

                right = mid - 1;

            }else if(result < num) {

                left = mid + 1;

            }else {

                return true;

            }

        }

        return false;

    }

}
