package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class E160 {

    /**
     * 双指针，a 和 b 交换前进即可对其长度
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {

            return null;

        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {

            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;

        }

        return p1;

    }

    /**
     * set解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {

            return null;

        }

        Set<ListNode> set = new HashSet<>();

        while(headA != null) {

            set.add(headA);
            headA = headA.next;

        }

        while(headB != null) {

            if(set.contains(headB)) {

                return headB;

            }

            headB = headB.next;

        }

        return null;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
