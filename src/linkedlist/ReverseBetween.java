package linkedlist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode guard = dummy;
        ListNode point = dummy.next;
        int step = 0;
        while (step < m - 1) {
            guard = guard.next;
            point = point.next;
            step++;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removed = point.next;
            point.next = point.next.next;
            removed.next = guard.next;
            guard.next = removed;
        }
        return dummy.next;
    }
}
