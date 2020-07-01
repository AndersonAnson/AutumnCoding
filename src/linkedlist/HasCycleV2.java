package linkedlist;

public class HasCycleV2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        ListNode other = head;
        while (slow != other) {
            slow = slow.next;
            other = other.next;
        }
        return slow;
    }
}
