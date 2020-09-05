package test.haoweilai;

import linkedlist.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}
