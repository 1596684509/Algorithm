package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E144 {

    @Test
    public void t() {

        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        for (Integer i : preorderTraversal(treeNode)) {

            System.out.println(i);

        }


    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null) {

            return list;

        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode t = stack.pop();
            list.add(t.val);

            if(t.right != null) {

                stack.push(t.right);

            }

            if(t.left != null) {

                stack.push(t.left);

            }

        }

        return list;

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
