package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class E706 {

    private List<HashNode> buckets;
    private int size;
    private int buketsLength;

    public E706() {

        buckets = new ArrayList<>();
        size = 0;
        buketsLength = 10;

        for (int i = 0; i < buketsLength; i++) {

            buckets.add(null);

        }

    }

    @Test
    public void t() {

        E706 has = new E706();
        has.put(1, 1);
        has.put(2, 2);
        has.put(3, 3);
        has.get(4);


    }

    public void put(int key, int value) {

        HashNode head = getHashNode(key);

        if(head != null) {

            head.value = value;
            return;

        }

        HashNode newNode = new HashNode(key, value);
        head = buckets.get(getBucketIndex(key));
        newNode.next = head;
        buckets.set(getBucketIndex(key), newNode);
        size++;

        if((1.0 * size) / buketsLength >= 0.8) {

            addLength();

        }

    }

    public int get(int key) {

        HashNode hashNode = getHashNode(key);

        return hashNode == null ? -1 : hashNode.value;

    }

    public void remove(int key) {

        int index = getBucketIndex(key);
        HashNode hashNode = buckets.get(index);
        HashNode prev = null;

        while(hashNode != null) {

            if(hashNode.key == key) {
                break;
            }

            prev = hashNode;
            hashNode = hashNode.next;

        }

        if(hashNode == null) {
            return;
        }

        if(prev != null) {

            prev.next = hashNode.next;

        }else {

            buckets.set(index, hashNode.next);

        }
        size--;

    }

    private HashNode getHashNode(int key) {

        int index = getBucketIndex(key);
        HashNode head = buckets.get(index);

        while(head != null) {

            if(head.key == key) {
                return head;
            }

            head = head.next;

        }

        return null;

    }

    private int getBucketIndex(int key) {

        return key % buketsLength;

    }

    private static class HashNode {

        private int key;
        private int value;
        private HashNode next;

        public HashNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void addLength() {

        List<HashNode> tmp = buckets;
        buckets = new ArrayList<>();
        buketsLength = buketsLength << 1;
        for (int i = 0; i < buketsLength; i++) {

            buckets.add(null);

        }

        for (HashNode hashNode : tmp) {

            while(hashNode != null) {

                put(hashNode.key, hashNode.value);
                hashNode = hashNode.next;

            }

        }

    }

}
