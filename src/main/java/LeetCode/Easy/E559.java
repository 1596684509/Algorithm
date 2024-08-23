package LeetCode.Easy;

import java.util.List;

public class E559 {

    public int maxDepth(Node root) {

        if(root == null) {
            return 0;
        }

        int l = root.children.isEmpty() ? 0 : maxDepth(root.children.get(0));
        int r = root.children.size() < 2 ? 0 : maxDepth(root.children.get(1));

        return Math.max(l, r) + 1;

    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
