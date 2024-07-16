package LeetCode.Easy;

import DataStructure.ArrayList;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Array;
import java.util.Arrays;

public class E108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0) {

            return null;

        }

        int mid = nums.length / 2 - 1;

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length - 1));
        return treeNode;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
