package LeetCode.Easy;

public class E671 {

    private int min = Integer.MAX_VALUE;
    private int slMin = -1;
    private boolean isSingle = true;
    private int log;

    public int findSecondMinimumValue(TreeNode root) {

        log = root.val;
        getMin(root);
        return isSingle ? -1 : slMin;

    }

    private void getMin(TreeNode root) {


        if(root == null) {

            return;

        }

        if(root.val != log) {

            isSingle = false;

        }

        if(root.val < min) {

            slMin = min;
            min = root.val;

        }else if(root.val > min && root.val <= slMin) {

            slMin = root.val;

        }

        getMin(root.left);
        getMin(root.right);

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
