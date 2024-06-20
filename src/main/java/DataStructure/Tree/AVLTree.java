package DataStructure.Tree;



import Algorithm.LinkedDeQue;

import java.util.Iterator;

public class AVLTree<T extends SrchTreeSampleAble> implements TreeAble<T>, Iterable<T> {

    private Note<T> root; // 根节点
    private int length; // 树的长度

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

    @Override
    public boolean add(T obj) {
        if (root == null) {
            root = new Note<>(obj, 1); // 初始节点高度为1
            length++;
            return true;
        } else {
            LinkedDeQue<Note<T>> compareQueues = new LinkedDeQue<>();
            Note<T> objPoint = root;

            while (true) {
                compareQueues.addHead(objPoint);

                if (obj.equals(objPoint.value)) {
                    return false;
                } else if (obj.getValue() < objPoint.value.getValue()) {
                    if (objPoint.left == null) {
                        objPoint.left = new Note<>(obj, 1);
                        length++;
                        break;
                    } else {
                        objPoint = objPoint.left;
                    }
                } else {
                    if (objPoint.right == null) {
                        objPoint.right = new Note<>(obj, 1);
                        length++;
                        break;
                    } else {
                        objPoint = objPoint.right;
                    }
                }
            }

            while (!compareQueues.isEmply()) {
                Note<T> adjustmentPoint = compareQueues.pollTail();
                updateHeight(adjustmentPoint);
                // 调整节点平衡
                adjustNode(adjustmentPoint, compareQueues.peekTail());
            }
        }
        return true;
    }

    @Override
    public T delete(T obj) {
        // 实现删除方法
        return null;
    }

    private Note<T> rightRotate(Note<T> y) {
        Note<T> x = y.left;
        Note<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Note<T> leftRotate(Note<T> x) {
        Note<T> y = x.right;
        Note<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private void updateHeight(Note<T> p) {
        int leftH = (p.left != null) ? p.left.height : 0;
        int rightH = (p.right != null) ? p.right.height : 0;
        p.height = 1 + Math.max(leftH, rightH);
    }

    /**
     * 对节点进行调整
     * @param p 调整节点
     * @param parentPoint 调整节点的父节点
     */
    private void adjustNode(Note<T> p, Note<T> parentPoint) {
        int balance = getBalance(p);

        if (balance > 1) {
            // 左子树过高，需要进行右旋
            if (getBalance(p.left) < 0) {
                // 左-右情况，先对左子节点进行左旋
                p.left = leftRotate(p.left);
            }
            // 右旋当前节点
            Note<T> newRoot = rightRotate(p);

            if (parentPoint != null) {
                if (parentPoint.left == p) {
                    parentPoint.left = newRoot;
                } else {
                    parentPoint.right = newRoot;
                }
            } else {
                root = newRoot;
            }
        } else if (balance < -1) {
            // 右子树过高，需要进行左旋
            if (getBalance(p.right) > 0) {
                // 右-左情况，先对右子节点进行右旋
                p.right = rightRotate(p.right);
            }
            // 左旋当前节点
            Note<T> newRoot = leftRotate(p);

            if (parentPoint != null) {
                if (parentPoint.left == p) {
                    parentPoint.left = newRoot;
                } else {
                    parentPoint.right = newRoot;
                }
            } else {
                root = newRoot;
            }
        }
    }

    private int getBalance(Note<T> p) {
        if (p == null) {
            return 0;
        }
        int leftH = (p.left != null) ? p.left.height : 0;
        int rightH = (p.right != null) ? p.right.height : 0;
        return leftH - rightH;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedDeQue<Note<T>> deque = new LinkedDeQue<>();
            boolean first = true;

            @Override
            public boolean hasNext() {
                if (first) {
                    deque.addHead(root);
                    first = false;
                }
                return deque.peekHead() != null;
            }

            @Override
            public T next() {
                Note<T> p = deque.pollHead();
                if (p.left != null) {
                    deque.addHead(p.left);
                }
                if (p.right != null) {
                    deque.addHead(p.right);
                }
                return p.value;
            }
        };
    }

    public int getLength() {
        return length;
    }

    private static class Note<T> {
        private Note<T> left;
        private Note<T> right;
        private int height;
        private T value;

        public Note(T value, int height) {
            this.value = value;
            this.height = height;
        }

        public Note<T> getLeft() {
            return left;
        }

        public void setLeft(Note<T> left) {
            this.left = left;
        }

        public Note<T> getRight() {
            return right;
        }

        public void setRight(Note<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
