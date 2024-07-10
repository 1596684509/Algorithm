package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E83 {

    /**
     * 快慢指针法
     */
    public E83() {
    }

    @Test
    public void test() {

        E83 e83 = new E83();
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        deleteDuplicates(listNode);

        while(listNode != null) {

            System.out.println(listNode.val);
            listNode = listNode.next;

        }

    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) {

            return head;

        }

        ListNode left = head;
        ListNode right = head.next;

        while(true) {

            if (left.val != right.val) {

                left.next = right;
                left = left.next;
                if (left.next == null) {

                    return head;

                }


            }

            if(right.next == null) {

                left.next = null;
                return head;

            }

            right = right.next;

        }

    }

    static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     }

}
