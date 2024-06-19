package DataStructure;

import java.util.Iterator;

public class ArrayQueue<T> implements QueueListener<T>, Iterable<T>{

    //容量
    private int size = Integer.MAX_VALUE;

    //头指针
    private int head = 0;
    //尾指针
    private int tail = head;

    private T[] array;

    public ArrayQueue(int size) {
        this.size = size;
    }

    /**
     * 数组实现的队列
     */
    public ArrayQueue() {
    }

    @Override
    public boolean offer(T obj) {

        if(array == null) {

            array = (T[]) new Object[size];

        }

        if(isFull()) {

            return false;

        }

        array[tail] = obj;
        tail = (tail + 1) % size ;

        return true;
    }

    @Override
    public T pool() {

        if(isEmpty()) {

            return null;

        }

        T obj = array[head];
        array[head] = null;
        head = (head + 1) % size;
        return obj;

    }

    @Override
    public T peek() {

        if(isEmpty()) {

            return null;

        }

        return array[head];

    }

    @Override
    public boolean isEmpty() {
        if(head == tail) {

            System.out.println("数组为空");
            return true;

        }

        return false;

    }

    public boolean isFull() {

        boolean b = (tail + 1) % size == head;

        if(b) {

            System.out.println("环形队列已满");

        }

       return b;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = head;

            @Override
            public boolean hasNext() {
                return index != tail;
            }

            @Override
            public T next() {
                T obj = array[index];
                index++;
                return obj;
            }
        };
    }
}
