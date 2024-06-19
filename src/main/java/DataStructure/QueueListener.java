package DataStructure;

public interface QueueListener<T> {

    //尾插入
    boolean offer(T obj);

    //头取出
    T pool();

    //获取头部数据
    T peek();

    boolean isEmpty();
    boolean isFull();
}
