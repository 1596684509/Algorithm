package LeetCode.Easy;

public class E203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode mH = new ListNode();

        mH.next = head;
        remove(mH, val);

        return mH.next;

    }

    public ListNode remove(ListNode head, int val) {

        if(head != null) {

            remove(head.next, val);

            if(head.next != null && head.next.val == val) {

                head.next = head.next.next;

            }

        }

        return head;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
