package DataStructure;

import java.util.Iterator;

public class QueueLinked<T> implements Iterable<T>, QueueListener<T>{
    
    
    private Node<T> head = new Node<>(null, null);
    //尾节点
    private Node<T> tail = head;

    /**
     * 链表实现的队列
     */
    public QueueLinked() {
        tail.next = head;
    }
    
    public boolean offer(T value) {

        Node<T> added = new Node<>(head, value);
        tail.next = added;
        tail = added;

        return true;

    }

    public T peek() {

        if(isEmpty()) {

            return null;

        }

        return head.next.data;

    }

    public T pool() {

        T obj = head.next.data;
        head.next = head.next.next;
        return obj;


    }

    public boolean isEmpty() {

        return head == tail;

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public T next() {

                T value = p.data;
                p = p.next;
                return value;
            }
        };
    }

    protected static class Node<T> {

        protected Node<T> next;
        protected T data;

        public Node(Node<T> next, T data) {
            this.next = next;
            this.data = data;
        }
    }
    
}
