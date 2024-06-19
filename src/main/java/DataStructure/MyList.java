package DataStructure;

import java.util.function.Consumer;

public interface MyList<T>{

    //添加元素
    void add(T obj);

    //删除最后一个元素
    T deleteLast();

    //通过索引删除指定元素
    T deleteForIndex(int index);

    //通过索引获取指定元素
    T get(int index);

    //通过索引检查指定元素是否为空
    boolean isEmpty(int index);

    //遍历
    void FE(Consumer<T> consumer);

    //获取数组长度
    int size();

    //插入元素
    void insert(int index, T obj);

}
