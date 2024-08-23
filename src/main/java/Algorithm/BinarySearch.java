package Algorithm;

public class BinarySearch {

    int[] nums;
    int target;

    /**
     * 二分查找
     * @param ints
     * @param target
     */
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
