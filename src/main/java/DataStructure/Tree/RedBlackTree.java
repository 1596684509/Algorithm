package DataStructure.Tree;

import Algorithm.LinkedDeQue;

import java.util.Iterator;

public class RedBlackTree<T extends SrchTreeSampleAble> implements Iterable<T>{

    private Note<T> root;

    public boolean add(T value) {
        if(root == null) {
            root = new Note<>(null, value);
            root.color = false;
            return true;
        } else {
            Note<T> p = root;
            while (true) {
                if(p.value.equals(value)) {
                    return false;
                }
                if(value.getValue() > p.value.getValue()) {
                    if(p.right == null) {
                        p.right = new Note<>(p, value);
                        p = p.right;
                        break;
                    } else {
                        p = p.right;
                    }
                } else {
                    if(p.left == null) {
                        p.left = new Note<>(p, value);
                        p = p.left;
                        break;
                    } else {
                        p = p.left;
                    }
                }
            }
            adjustment(p);
        }
        return true;
    }

    public T delete(T obj) {

        Note<T> deleteObj = getNote(obj);


        if(deleteObj == null) {

            return null;

        }

        Note<T> parent = deleteObj.parent;
        T v = deleteObj.value;

        //叶子节点
        if(isLeafNote(deleteObj)) {

            boolean b = deleteObj.color;

            if(isLeftNote(parent, deleteObj)) {

                parent.left = null;

            }else {

                parent.right = null;

            }

            if(!b) {



            }

            //单一节点
        }else if(hasSingleNote(deleteObj)) {

            Note<T> deleteObjchild = null;

            if(deleteObj.left != null) {

                deleteObjchild = deleteObjchild.left;

                if(isLeftNote(parent, deleteObj)) {

                    parent.left = deleteObjchild;


                }else {

                    parent.right = deleteObjchild;

                }

            }else {

                deleteObjchild = deleteObj.right;

                if(isLeftNote(parent, deleteObj)) {

                    parent.left = deleteObjchild;

                }else {

                    parent.right = deleteObjchild;

                }

            }

            deleteObjchild.parent = parent;
            deleteObjchild.setColor(false);

            //完美节点
        }else {

            if(deleteObj.left != null) {

                Note<T> precursor = getPrecursor(deleteObj);
                Note<T> preParent = precursor.parent;

                deleteObj.value = precursor.value;

                if(isLeafNote(precursor)) {

                    preParent.right = null;

                }else {

                  preParent.right = precursor.right;
                  preParent.right.parent = preParent;

                }

            }

        }

        return v;

    }

    /**
     * 获取前驱节点
     * @param note
     * @return 前驱节点
     */
    private Note<T> getPrecursor(Note<T> note) {

        Note<T> max = note.left;

        while(max.right != null) {

            max = max.right;

        }

        return max;

    }

    /**
     * 获取后继节点
     * @param note
     * @return 后继节点
     */
    private Note<T> getSuccessor(Note<T> note) {

        Note<T> min = note.right;

        while(min.left != null) {

            min = min.left;

        }

        return min;

    }

    /**
     * 查找子节点
     * @param parent 父节点
     * @param child 目标节点
     * @return true = 左节点 false = 右节点
     */
    private boolean isLeftNote(Note<T> parent, Note<T> child) {

        if(parent.left.value.equals(child.value)) {

            return true;

        }else if(parent.right.value.equals(child.value)) {

            return false;

        }else {

            throw new NullPointerException("未找到元素");

        }

    }

    private boolean hasSingleNote(Note<T> note) {

        if(note != null) {

            if(note.left == null && note.right != null) {

                return true;

            }else if(note.left != null && note.right == null) {

                return true;

            }

        }

        return false;

    }

    /**
     * 是否为叶子节点
     * @param p
     * @return
     */
    private boolean isLeafNote(Note<T> p) {

        return p.right == null && p.left == null;
    }

    public void clear() {

        root = null;

    }



    private void adjustment(Note<T> p) {
        while(p != root && p.parent.color) {
            if(p.parent != root) {
                Note<T> parent = p.parent;
                Note<T> grandFather = p.parent.parent;
                Note<T> uncle = grandFather.left == parent ? grandFather.right : grandFather.left;
                if(uncle != null && uncle.color) {
                    changeColor(p);
                } else {
                    rotate(p);
                }
            }
            p = p.parent;
        }
        if(p == root && p.color) {
            p.colorToggle();
        }
    }

    private void changeColor(Note<T> p) {
        Note<T> parent = p.parent;
        Note<T> grandFather = p.parent.parent;
        Note<T> uncle = grandFather.left == parent ? grandFather.right : grandFather.left;
        parent.colorToggle();
        grandFather.colorToggle();
        if (uncle != null) {
            uncle.colorToggle();
        }
    }

    private void rotate(Note<T> p) {
        Note<T> parent = p.parent;
        Note<T> grandFather = p.parent.parent;

        if(grandFather.left == parent) {
            if(parent.right == p) {
                leftRotate(parent);
                p = p.left;
            }
            rightRotate(grandFather);
        } else if(grandFather.right == parent) {
            if(parent.left == p) {
                rightRotate(parent);
                p = p.right;
            }
            leftRotate(grandFather);
        }

        // 调整颜色
        grandFather.colorToggle();
        parent.colorToggle();


    }

    private void leftRotate(Note<T> point) {
        Note<T> right = point.right;
        point.right = right.left;
        if (right.left != null) {
            right.left.parent = point;
        }
        right.parent = point.parent;
        if (point.parent == null) {
            root = right;
        } else if (point == point.parent.left) {
            point.parent.left = right;
        } else {
            point.parent.right = right;
        }
        right.left = point;
        point.parent = right;
    }

    private void rightRotate(Note<T> y) {
        Note<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    public T get(T obj) {

        return getNote(obj).value;

    }

    private Note<T> getNote(T obj) {

        Note<T> current = root;
        while (current != null) {
            if (current.value.equals(obj)) {
                return current;
            } else if (current.value.getValue() > obj.getValue()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;

    }

    public void breadthOrder() {

        for (T t : this) {
            System.out.print(t.getValue() + " ");
        }

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


    private static class Note<T extends SrchTreeSampleAble> {
        private T value;
        private Note<T> parent;
        private Note<T> left;
        private Note<T> right;
        //节点颜色 true = 红色;
        private boolean color = true;

        public Note(Note<T> parent, T value) {
            this.parent = parent;
            this.value = value;
        }

        public boolean getColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Note<T> getParent() {
            return parent;
        }

        public void setParent(Note<T> parent) {
            this.parent = parent;
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

        public void colorToggle() {
            color = !color;
        }
    }
}
