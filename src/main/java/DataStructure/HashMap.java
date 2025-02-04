package DataStructure;

import javax.swing.*;
import java.util.ArrayList;

public class HashMap {

    private ArrayList<HashNode<String, Integer>> bucketArray;
    private int bucketSize;
    private int size;

    public HashMap() {

        bucketArray = new ArrayList<>();
        bucketSize = 10;
        size = 0;

        for (int bucketIndex = 0; bucketIndex < bucketSize; bucketIndex++) {

            bucketArray.add(null);

        }

    }

    /**
     * 通过key的哈希值求下标
     * @param key
     * @return
     */
    private int getBucketIndex(String key) {

        return key.hashCode() % bucketSize;

    }

    //TODO add(Key, Value)
    public void add(String key, Integer value) {

        int index = getBucketIndex(key);
        HashNode<String, Integer> head = getHashNode(key);

        if(head != null) {
            head.value = value;
            return;
        }

        head = bucketArray.get(index);
        HashNode<String, Integer> hashNode = new HashNode<>(key, value);
        hashNode.next = head;
        bucketArray.set(index, hashNode);
        size++;

        //当数量大于桶长度 70 % 的时候 扩充桶
        if((1.0 * size) / bucketSize >= 0.7) {

            generatebiggerArray();

        }

    }

    //对桶进行扩充
    public void generatebiggerArray() {

        ArrayList<HashNode<String, Integer>> tmp = bucketArray;
        bucketArray = new ArrayList<>();
        bucketSize = bucketSize << 1;

        for (int i = 0; i < bucketSize; i++) {
            bucketArray.add(null);
        }
        size = 0;

        for (HashNode<String, Integer> hashNode : tmp) {

            while(hashNode != null) {

                add(hashNode.key, hashNode.value);
                hashNode = hashNode.next;

            }

        }

    }

    private HashNode<String, Integer> getHashNode(String key) {

        int index = getBucketIndex(key);
        HashNode<String, Integer> head = bucketArray.get(index);

        while(head != null) {

            if(head.key.equals(key)) {

                return head;

            }

            head = head.next;

        }

        return null;

    }

    //TODO get(Key)
    public Integer get(String key) {

        return getHashNode(key) == null ? null : getHashNode(key).value;

    }

    //TODO remove(Key)
    public Integer remove(String key) {

        int bucketIndex = getBucketIndex(key);
        HashNode<String, Integer> head = bucketArray.get(bucketIndex);
        HashNode<String, Integer> prev = null;

        while(head != null) {

            if(head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;

        }

        if(head == null) {

            return null;

        }

        if(prev != null) {

            prev.next = head.next;

        }else {

            bucketArray.set(bucketIndex, head.next);

        }

        size--;
        return head.value;

    }

    //TODO size()
    public int size() {
        return size;
    }

    //TODO isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    private static class HashNode<String, Integer> {

        private String key;
        private Integer value;
        private HashNode<String, Integer> next;

        private HashNode(String key, Integer value) {

            this.key = key;
            this.value = value;

        }

    }

}
