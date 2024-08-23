package LeetCode.Easy;

public class E530 {

    private int min = Integer.MAX_VALUE; // 初始化为一个较大的值
    private Integer head = null; // 使用 Integer 以处理初次赋值

    public int getMinimumDifference(TreeNode root) {
        foreach(root);
        return min;
    }

    private void foreach(TreeNode r) {
        if (r == null) {
            return;
        }

        // 递归遍历左子树
        foreach(r.left);

        // 如果 head 不是 null，计算差值并更新 min
        if (head != null) {
            min = Math.min(min, Math.abs(r.val - head));
        }

        // 更新 head 为当前节点值
        head = r.val;

        // 递归遍历右子树
        foreach(r.right);
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
