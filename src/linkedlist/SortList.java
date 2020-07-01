package linkedlist;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                ListNode newNode = new ListNode(left.val);
                curr.next = newNode;
                curr = curr.next;
                left = left.next;
            } else {
                ListNode newNode = new ListNode(right.val);
                curr.next = newNode;
                curr = curr.next;
                right = right.next;
            }
        }
        curr.next = left == null ? right : left;
        return dummy.next;
    }
}
