package DataStructure.Tree;

public class RedBlackTree<T extends SrchTreeSampleAble> {

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

    private static class Note<T extends SrchTreeSampleAble> {
        private T value;
        private Note<T> parent;
        private Note<T> left;
        private Note<T> right;
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
