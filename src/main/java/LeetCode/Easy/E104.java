package LeetCode.Easy;

import java.math.MathContext;

public class E104 {

    public int maxDepth(TreeNode root) {

        if(root == null) {

            return 0;

        }

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));

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
