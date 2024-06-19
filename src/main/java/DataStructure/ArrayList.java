package DataStructure;

import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayList<T> implements MyList<T>, Iterable<T>{

    //数组
    private T[] array;
    //元素个数
    private int size;
    //数组长度
    private int length = 10;

    /**
     * 数组
     */
    public ArrayList() {
    }

    @Override
    public void add(T obj) {

        if(array == null || size >= length) {

            addLength();

        }

        array[size] = obj;
        size++;

    }



    @Override
    public boolean isEmpty(int index) {

        throwError(index);
        if(array[index] == null){

            return true;

        }

        return false;

    }

    private void addLength() {

        if(array == null) {

            array = (T[]) new Object[length];

        }else {

            length += length;
            T[] newArray = (T[]) new Object[length];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

        }



    }

    @Override
    public T get(int index) {
        throwError(index);
        return (T) array[index];
    }

    @Override
    public void FE(Consumer<T> consumer) {

        for (int i = 0; i < size; i++) {

            consumer.accept((T) array[i]);

        }


    }

    private void throwError(int index) {

        if(index < 0 || index >= size) {

            throw new IndexOutOfBoundsException(String.format("你输入的索引不合法 索引[%d]%n", index));

        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int index, T obj) {

        if(size >= length) {

            addLength();

        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = obj;
        size++;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public T deleteLast() {

        T obj = array[size - 1];
        array[size - 1] = null;
        System.arraycopy(array, 0, array, 0, size-1);
        size--;
        return obj;

    }

    @Override
    public T deleteForIndex(int index) {

        throwError(index);
        T obj = array[index];
        System.arraycopy(array, index+1, array, index, size - index-1);
        array[size - 1] = null;
        size--;
        return obj;

    }
}
