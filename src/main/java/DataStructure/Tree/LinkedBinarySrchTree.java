package DataStructure.Tree;

public class LinkedBinarySrchTree<T extends SrchTreeSampleAble> extends LinkedCompleteBinaryTree<T>{


    private Note<T> objPoint;
    /**
     * 二叉搜索树
     */
    public LinkedBinarySrchTree() {

        super();

    }

    @Override
    public boolean add(T element) {
        if (root == null) {
            root = new Note<>(element, null, null);
            length++;
            return true;
        }

        Note<T> current = root;
        Note<T> parent = null;

        while (true) {
            parent = current;

            if (element.getValue() < current.value.getValue()) {
                current = current.left;
                if (current == null) {
                    parent.left = new Note<>(element, null, null);
                    length++;
                    return true;
                }
            } else if (element.getValue() > current.value.getValue()) {
                current = current.right;
                if (current == null) {
                    parent.right = new Note<>(element, null, null);
                    length++;
                    return true;
                }
            } else {
                return false; // Duplicate value, do not add
            }
        }
    }

    @Override
    public T get(T obj) {
        Note<T> current = root;

        while (current != null) {
            if (current.value.equals(obj)) {
                return current.value;
            } else if (current.value.getValue() > obj.getValue()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
}
