package DataStructure.Tree;

import Algo.LinkedDeQue;

import java.util.Iterator;

public class LinkedCompleteBinaryTree<T> implements TreeAble<T>, Iterable<T>{

    protected Note<T> root;
    protected int length;
    protected LinkedDeQue<Note<T>> deque = new LinkedDeQue<>();

    /**
     * 完全二叉树
     * 链表实现
     */
    public LinkedCompleteBinaryTree() {
    }

    public boolean add(T element) {

        if(root == null) {

            root = new Note<>(element, null, null);
            length++;
            deque.addHead(root);
            return true;
        }

        Note<T> lastNote = deque.peekHead();

        if(lastNote.left == null) {

            lastNote.left = new Note<>(element, null, null);
            length++;

        }else if(lastNote.right == null) {

            lastNote.right = new Note<>(element, null, null);
            length++;

        }else {

            deque.addHead(lastNote.left);
            deque.addHead(lastNote.right);
            deque.pollHead();
            add(element);

        }

        return true;

    }

    private Note<T> getNote(T obj) {

        if(root == null) {

            return null;

        }else if(root.value.equals(obj)) {

            return root;

        }

        LinkedDeQue<Note<T>> deQue = new LinkedDeQue<>();
        deQue.addHead(root);

        while (true) {

            Note<T> p = deQue.pollHead();

            if(p == null) {

                break;

            }

            if(p.left != null || p.right != null) {

                if(p.left != null) {

                    if(p.left.value.equals(obj)) {

                        return p.left;

                    }
                    deQue.addHead(p.left);

                }

                if(p.right != null) {

                    if(p.right.value.equals(obj)) {

                        return p.right;

                    }

                    deQue.addHead(p.right);

                }

            }

        }

        return null;

    }

    @Override
    public T get(T obj) {

        if(getNote(obj) == null) {

            return null;

        }

        return getNote(obj).value;

    }

    @Override
    public T delete(T obj) {

        Note<T> lastNote = deque.peekHead();
        T deleteed = null;

        if(getNote(obj) != null) {

            deleteed = getNote(obj).value;

            if(lastNote.right!= null) {

                getNote(obj).value = lastNote.right.value;
                lastNote.right = null;
                length--;

            }else if(lastNote.left != null) {

                getNote(obj).value = lastNote.left.value;
                lastNote.left = null;
                length--;

            }

        }


        return deleteed;

    }
    public int getLength() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            LinkedDeQue<Note<T>> deQue = new LinkedDeQue<>();
            boolean first = true;
            @Override
            public boolean hasNext() {

                if(first) {

                    deQue.addHead(root);
                    first = false;

                }

                return deQue.peekHead() != null;
            }

            @Override
            public T next() {

                Note<T> p = deQue.pollHead();
                if(p.left != null) {

                    deQue.addHead(p.left);

                }

                if(p.right != null) {

                    deQue.addHead(p.right);

                }

                return p.value;

            }
        };
    }

    protected static class Note<T> {

        protected T value;
        protected Note<T> left;
        protected Note<T> right;

        public Note(T value, Note<T> left, Note<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }



    }

}
