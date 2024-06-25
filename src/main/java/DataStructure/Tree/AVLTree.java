package DataStructure.Tree;



import Algorithm.LinkedDeQue;

import javax.xml.stream.XMLInputFactory;
import java.util.Iterator;
import java.util.Objects;

public class AVLTree<T extends SrchTreeSampleAble> implements TreeAble<T>, Iterable<T> {

    private Note<T> root; // 根节点
    private int length; // 树的长度

    @Override
    public T get(T obj) {

        return Objects.requireNonNull(getSrchPathNoteArray(obj)).peekTail().value;

    }

    /**
     * 使用队列头插法查找目标节点，并返回队列
     * @param obj 目标节点
     * @return 根节点至目标节点的节点组
     */
    private LinkedDeQue<Note<T>> getSrchPathNoteArray(T obj) {

        LinkedDeQue<Note<T>> linkedDeQue = new LinkedDeQue<>();

        Note<T> current = root;
        linkedDeQue.addHead(current);
        while (current != null) {

            if (current.value.equals(obj)) {
                return linkedDeQue;
            } else if (current.value.getValue() > obj.getValue()) {
                current = current.left;
            } else {
                current = current.right;
            }

            linkedDeQue.addHead(current);
        }
        return null;

    }

    /**
     * 使用队列头插法查找目标值，并返回队列
     * @param obj 目标节点
     * @param isQueue 是否以队列形式返回 true = 队列, false = 栈
     * @return 根节点至目标节点的节点组
     */
    public LinkedDeQue<T> getSrchPathValueArray(T obj, boolean isQueue) {

        LinkedDeQue<T> linkedDeQue = new LinkedDeQue<>();

        for (Note<T> tNote : getSrchPathNoteArray(obj)) {

            if(isQueue) {

                linkedDeQue.addHead(tNote.value);

            }else {

                linkedDeQue.addTail(tNote.value);

            }

        }

        return linkedDeQue;

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

            balanceTree(compareQueues);
        }
        return true;
    }

    /**
     * 删除目标节点
     * 先查找后删除
     * @param obj
     * @return 被删除的节点
     */
    @Override
    public T delete(T obj) {

        LinkedDeQue<Note<T>> noteArray = getSrchPathNoteArray(obj);
        Note<T> deleteNote = noteArray.pollTail();
        Note<T> parentNote = noteArray.peekTail();
        T value = deleteNote.value;

        //保存被修改的的路径
        LinkedDeQue<Note<T>> upDateNotePath = null;

        if(deleteNote == null) {

            return null;

        }else {

            if(isLeafNote(deleteNote)) {

                if(deleteNote.equals(root)) {

                    clear();

                }else {

                    if(parentNote.left != null && parentNote.left.equals(deleteNote)) {

                        parentNote.left = null;

                    }else {

                        parentNote.right = null;

                    }

                }

            }else if(deleteNote.left == null) {

                upDateNotePath = getSuccessorNote(deleteNote);
                Note<T> successorNote = upDateNotePath.pollTail();
                Note<T> successorParent = upDateNotePath.peekTail();
                deleteNote.value = successorNote.value;
                if(successorParent != null) {

                    successorParent.left = null;

                }else {

                    deleteNote.right = null;

                }

            }else {

                upDateNotePath = getPrecursorNote(deleteNote);
                Note<T> precursor = upDateNotePath.pollTail();
                Note<T> precursorParent = upDateNotePath.peekTail();
                deleteNote.value = precursor.value;
                if(precursorParent != null) {

                    precursorParent.right = null;

                }else {

                    deleteNote.left = null;

                }

            }

            //调整
            if(upDateNotePath != null) {

                balanceTree(upDateNotePath);

            }

            balanceTree(noteArray);

        }

        return value;

    }

    private void balanceTree(LinkedDeQue<Note<T>> tree) {

        if(tree != null) {

            while(!tree.isEmply()) {
                Note<T> adjustNode = tree.pollTail();
                updateHeight(adjustNode);
                adjustNode(adjustNode, tree.peekTail());

            }

        }

    }

    /**
     * 获取前驱节点的查找路径
     * @param p 目标节点
     * @return 从目标节点的右节点开始到前驱节点的路径
     */
    private LinkedDeQue<Note<T>> getPrecursorNote(Note<T> p) {

        LinkedDeQue<Note<T>> linkedDeQue = new LinkedDeQue<>();

        if(p.left == null) {

            return linkedDeQue;

        }else {

            Note<T> max = p.left;
            linkedDeQue.addHead(max);

            while(max.right != null) {

                max = max.right;
                linkedDeQue.addHead(max);

            }

            return linkedDeQue;

        }

    }

    /**
     * 获取后继节点的查找路径
     * @param p 目标节点
     * @return 从目标节点的右节点开始到后继节点的路径
     */
    private LinkedDeQue<Note<T>> getSuccessorNote(Note<T> p) {

        LinkedDeQue<Note<T>> linkedDeQue = new LinkedDeQue<>();

        if(p.right == null) {

            return linkedDeQue;

        }else {

            Note<T> min = p.right;
            linkedDeQue.addHead(min);

            while(min.left != null) {

                min = min.left;
                linkedDeQue.addHead(min);

            }

            return linkedDeQue;

        }

    }

    private boolean isLeafNote(Note<T> p) {

        return p.right == null && p.left == null;
    }

    public void clear() {

        root = null;

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


    private void preOrder(Note<T> p) {

        if(p != null) {

            System.out.print(p.value.getValue() + " ");
            preOrder(p.left);
            preOrder(p.right);

        }

    }

    /**
     * 前序遍历
     */
    public void preOrder() {

        preOrder(root);

    }


    private void midOrder(Note<T> p) {

        if(p != null) {

            midOrder(p.left);
            System.out.print(p.value.getValue() + " ");
            midOrder(p.right);

        }

    }

    /**
     * 前序遍历
     */
    public void minOrder() {

        midOrder(root);

    }

    private void afterOrder(Note<T> p) {

        if(p != null) {

            afterOrder(p.left);
            afterOrder(p.right);
            System.out.print(p.value.getValue() + " ");

        }

    }

    /**
     * 前序遍历
     */
    public void afterOrder() {

        afterOrder(root);

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
