package LeetCode.Easy;

public class E35 {

    public static void main(String[] args) {

        int[] ins = new int[]{1,3, 5, 6};

        System.out.println(searchInsert(ins, 5));

    }

    public static int searchInsert(int[] nums, int target) {

        return new BinarySearch(nums, target).searchIndex();

    }

    static class BinarySearch {

        int[] nums;
        int target;

        public BinarySearch(int[] ints, int target) {
            this.nums = ints;
            this.target = target;
        }

        public int searchIndex() {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

    }

}
