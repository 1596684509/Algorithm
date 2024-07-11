package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E94 {


    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while(root != null || !stack.isEmpty()) {

            while(root != null) {

                stack.push(root);
                root = root.left;

            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }

        return list;

    }

    class TreeNode {

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
