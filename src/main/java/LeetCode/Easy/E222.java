package LeetCode.Easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class E222 {

    @Test
    public void t() {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(8);
        TreeNode node10 = new TreeNode(9);
        TreeNode node11 = new TreeNode(10);

        // 构建树结构
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;
        node5.right = node11;

        System.out.println(countNodes(node1));


    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root, true);  // 左子树的高度
        int rightHeight = getHeight(root, false); // 右子树的高度

        if (leftHeight == rightHeight) {
            // 左子树高度等于右子树高度，说明左子树是完全树
            return (1 << leftHeight) - 1; // 2^height - 1
        } else {
            // 递归计算左子树的节点数和右子树的节点数
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getHeight(TreeNode node, boolean isLeft) {
        int height = 0;
        while (node != null) {
            height++;
            node = isLeft ? node.left : node.right;
        }
        return height;
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
