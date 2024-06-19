package DataStructure;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<T> implements MyList<T>, Iterable<T>{

    protected Node<T> node;
    protected int size = 0;

    /**
     * 链表
     */
    public LinkedList() {
    }

    @Override
    public void add(T obj) {

        node = new Node<>(node, obj);
        size++;

    }

    /**
     * 通过索引获取节点
     * @param index 索引 -1返回最后一个节点
     * @return
     */
    protected Node<T> findNode(int index) {

        if(node == null) {

            return null;

        }

        int i = 0;

        Node point;
        for (point = node; point.next != null ; point = point.next) {

            if(i == index) {

                return point;

            }
            i++;

        }

        return point;

    }

    /**
     * 添加新的元素 onLast
     * @param obj
     * @param onLast true 为尾部插入
     */
    public void add(T obj, boolean onLast) {

        if(onLast && node != null) {

            Node point = findNode(-1);
            point.next = new Node<>(null, obj);
            size++;

        }else {

            add(obj);

        }

    }

    @Override
    public T deleteLast() {

        Node<T> point;
        T deleteedObj = null;

        if(size == 1) {

            deleteedObj = node.data;
            node = null;
            return deleteedObj;

        }

        for (point = node; point.next != null ; point = point.next) {
            if(point.next.next == null) {
                deleteedObj = point.next.data;
                point.next = null;
                break;

            }
        }
        size--;
        return deleteedObj;
    }

    @Override
    public T deleteForIndex(int index) {

        Node<T> p = findNode(index);
        Node<T> deleteObj = p.next;
        p.next = p.next.next;
        size--;
        return deleteObj.data;
    }

    @Override
    public T get(int index) {

        return findNode(index).data;

    }

    @Override
    public boolean isEmpty(int index) {
        return false;
    }

    @Override
    public void FE(Consumer<T> consumer) {

        Node<T> point;
        for (point = node; point.next != null; point = point.next) {

            consumer.accept(point.data);

        }

    }

    /**
     * 反转链表
     * @param reverseed 一个空的链表
     * @return 反转后的链表
     */
    public LinkedList<T> reverse1(LinkedList<T> reverseed) {

        if(findNode(-1) == null) {
            return reverseed;
        }

        reverseed.add(deleteLast(), true);
        reverse1(reverseed);




        return reverseed;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int index, T obj) {

        if(index >= 0) {

            if(index == 0) {

                add(obj);

            }else {

                Node<T> p = findNode(index - 1);
                p.next = new Node<>(p.next, obj);
                size++;

            }

        }else {

            throw new IndexOutOfBoundsException();

        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> point = node;

            @Override
            public boolean hasNext() {
                return point != null;
            }

            @Override
            public T next() {
                T obj = point.data;
                point = point.next;
                return obj;
            }
        };
    }

    protected static class Node<T> {

        protected Node<T> next;
        protected T data;

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }
    }

}
