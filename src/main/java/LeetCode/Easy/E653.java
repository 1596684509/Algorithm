package LeetCode.Easy;

import java.util.*;

public class E653 {

    public boolean findTarget(TreeNode root, int k) {

        if(root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while(!deque.isEmpty()) {

            TreeNode p = deque.pop();
            if(!set.contains(k - p.val)) {

                set.add(p.val);

            }else {
                return true;
            }

            if(p.left != null) {

                deque.push(p.left);

            }

            if(p.right != null) {

                deque.push(p.right);

            }

        }

        return false;

    }

    private boolean findTargetOther(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();
        return order(root, k, set);

    }

    private boolean order(TreeNode root, int k, Set<Integer> set) {

        if(root == null) {
            return false;
        }

        if(!set.contains(k - root.val)) {

            set.add(root.val);

        }else {

            return true;

        }

        return order(root.left, k, set) || order(root.right, k, set);

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
