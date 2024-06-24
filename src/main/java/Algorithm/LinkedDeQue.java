package Algorithm;

import java.util.Iterator;

public class LinkedDeQue<T> implements Iterable<T>{

    private Node<T> head = new Node<>(null, null, null);
    private Node<T> tail = new Node<>(null, null, null);
    private int size = Integer.MAX_VALUE;
    private int length = 0;

    /**
     * 双端队列
     * 头部添加 头部取出 为队列 FIFO
     * 头部添加 尾部取出 为栈 FILO
     */
    public LinkedDeQue() {

        head.next = tail;
        tail.priv = head;


    }

    public LinkedDeQue(int size) {

        this();
        this.size = size;

    }

    public boolean addHead(T obj) {

        if(isFull()) {

            return false;

        }

        Node<T> data = new Node<>(obj, head.next, head);

        if(isEmply()) {

            tail.priv = data;

        }else {

            head.next.priv = data;

        }

        head.next = data;

        length++;
        return true;

    }

    public T pollHead() {

        if(isEmply()) {

            return null;

        }

        T obj = tail.priv.value;
        tail.priv = tail.priv.priv;
        length--;
        return obj;

    }

    public T pollTail() {

        if(isEmply()) {

            return null;

        }

        T obj = head.next.value;
        head.next = head.next.next;
        length--;
        return obj;

    }

    public boolean addTail(T obj) {

        if(isFull()) {

            return false;

        }

        Node<T> data = new Node<>(obj, tail, tail.priv);

        if(isEmply()) {

            head.next = data;

        }else {

            tail.priv.next = data;

        }

        tail.priv = data;

        length++;
        return true;

    }

    public T peekHead() {

        return tail.priv.value;

    }

    public T peekTail() {


        return head.next.value;

    }

    public boolean isFull() {

        boolean b = length == size;
        return b;

    }

    public boolean isEmply() {

        boolean b = length == 0;
        return b;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> p = head.next;
            @Override
            public boolean hasNext() {
                return p.next != null;
            }

            @Override
            public T next() {
                T v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> priv;

        public Node(T value, Node<T> next, Node<T> priv) {
            this.value = value;
            this.next = next;
            this.priv = priv;
        }

    }

}
