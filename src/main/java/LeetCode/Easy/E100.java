package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.util.Stack;

public class E100 {

    @Test
    public void t1() {

        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        isSameTree(t1, t2);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if((p == null && q == null)) {

            return true;

        }

        if(p == null || q == null) {

            return false;

        }

        if(p.val != q.val) {

            return false;

        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    class TreeNode {
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
