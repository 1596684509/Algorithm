package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class E572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return isSametree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean isSametree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isSametree(s.left,t.left) && isSametree(s.right,t.right);
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
