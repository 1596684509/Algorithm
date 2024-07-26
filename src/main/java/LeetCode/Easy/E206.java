package LeetCode.Easy;

import java.util.List;
import java.util.Stack;

public class E206 {

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {


            return head;

        }

        ListNode newP = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newP;

    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
