package LeetCode.Easy;

public class E543 {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {

        max = 1;
        searchMaxLength(root);
        return max - 1;

    }

    public int searchMaxLength(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int L = searchMaxLength(root.left);
        int R = searchMaxLength(root.right);

        max = Math.max(max, L + R + 1);
        return Math.max(L, R) + 1;

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
