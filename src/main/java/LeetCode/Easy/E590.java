package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class E590 {

    public List<Integer> postorder(Node root) {
        List<Integer> integers = new ArrayList<>();
        order(root, integers);
        return integers;
    }

    public void order(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // 遍历所有子节点
        for (Node child : root.children) {
            order(child, list);
        }

        list.add(root.val);
    }

    class Node {
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
    };

}
