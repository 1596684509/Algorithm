package LeetCode.Easy;

public class E234 {

    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        /* 第一步：先找中间节点 */
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            slow=slow.next;
        }
        /* 第三步：依次比较两个子链表节点 */
        ListNode head_new=reverseList(slow);
        while(head_new!=null){
            if(head.val!=head_new.val) return false;
            head_new=head_new.next;
            head=head.next;
        }
        return true;

    }
    /* 第二步：翻转链表 */
    public ListNode reverseList(ListNode node){
        ListNode pre=null;
        ListNode curr=node;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
