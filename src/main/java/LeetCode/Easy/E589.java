package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class E589 {

    public List<Integer> preorder(Node root) {

        List<Integer> integers = new ArrayList<>();
        order(root, integers);
        return integers;

    }

    public void order(Node root, List<Integer> list) {

        if(root == null) {
            return;
        }

        if(!root.children.isEmpty()) {
            order(root.children.get(0), list);
        }

        if(root.children.size() > 1) {

            order(root.children.get(1), list);

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
    }

}
