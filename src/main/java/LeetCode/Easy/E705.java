package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class E705 {

    private ArrayList<HashNode> buckets;
    private int bucketsSize;
    private int size;


    public E705() {

        buckets = new ArrayList<>();
        bucketsSize = 10;
        size = 0;

        for (int i = 0; i < bucketsSize; i++) {
            buckets.add(null);
        }

    }

    public int getBucketsIndex(int key) {

        return Integer.valueOf(key).hashCode() % bucketsSize;

    }

    public void add(int key) {

        int index = getBucketsIndex(key);
        HashNode head = buckets.get(index);

        while(head != null) {

            if(head.value == key) {

                return;

            }
            head = head.next;

        }

        HashNode hashNode = new HashNode(key);
        head = buckets.get(index);
        hashNode.next = head;
        buckets.set(index, hashNode);
        size++;

        if((1.0 * size) / bucketsSize >= 0.7) {

            generatebiggerArray();

        }

    }

    private void generatebiggerArray() {

        ArrayList<HashNode> tmp = buckets;
        buckets = new ArrayList<>();
        bucketsSize = bucketsSize << 1;

        for (int i = 0; i < bucketsSize; i++) {

            buckets.add(null);

        }

        for (HashNode hashNode : tmp) {

            while(hashNode != null) {
                add(hashNode.value);
                hashNode = hashNode.next;
            }

        }

    }

    public void remove(int key) {

        int index = getBucketsIndex(key);
        HashNode head = buckets.get(index);
        HashNode prev = null;

        while(head != null) {

            if(head.value == key) {
                break;
            }

            prev = head;
            head = head.next;

        }

        if(head == null) {
            return;
        }

        if(prev != null) {
            prev.next = head.next;
        }else {
            buckets.set(index, head.next);
        }
        size--;

    }

    public boolean contains(int key) {

        int index = getBucketsIndex(key);
        HashNode head = buckets.get(index);

        while(head != null) {

            if(head.value == key) {
                return true;
            }
            head = head.next;

        }

        return false;

    }

    private static class HashNode {

        private int value;
        private HashNode next;

        public HashNode(int value) {
            this.value = value;
        }
    }

}
