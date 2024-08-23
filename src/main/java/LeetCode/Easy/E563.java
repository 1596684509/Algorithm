package LeetCode.Easy;

public class E563 {

    int res;

    public int findTilt(TreeNode root) {
        res = 0;
        sum(root);
        return res;
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = sum(node.left);
        int sumRight = sum(node.right);
        res += Math.abs(sumLeft - sumRight);
        return node.val + sumLeft + sumRight;
    }

    public class TreeNode {
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
