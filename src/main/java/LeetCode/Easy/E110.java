package LeetCode.Easy;

import java.math.MathContext;

public class E110 {

    public boolean isBalanced(TreeNode root) {

        if(root == null) {

            return true;

        }

        return height(root) >= 0;

    }

    public int height(TreeNode t) {

        if(t == null) {

            return 0;

        }

        int leftH = height(t.left);
        int rightH = height(t.right);

        if(leftH >= 0 && rightH >= 0 && Math.abs(leftH - rightH) <= 1) {

            return Math.max(leftH, rightH) + 1;

        }else {

            return -1;

        }



    }

    private class TreeNode {
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
