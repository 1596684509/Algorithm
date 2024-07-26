package LeetCode.Easy;

public class E141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {

            return false;

        }

        ListNode tail = head.next;

        while(tail.next != null) {


            if(tail == head) {

                return true;

            }

            head = head.next;
            tail = tail.next.next;

        }

        return false;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
