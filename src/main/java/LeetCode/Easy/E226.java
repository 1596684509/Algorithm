package LeetCode.Easy;

public class E226 {

    public E226() {}

    public TreeNode invertTree(TreeNode root) {

        if(root == null) {

            return null;

        }

        TreeNode right = root.right;

        root.right = invertTree(root.left);
        root.left = invertTree(right);

        return root;

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
