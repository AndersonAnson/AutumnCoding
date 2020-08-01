package swordToOffer;

public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 快慢碰上了
                ListNode other = pHead;
                while (other != slow) {
                    other = other.next;
                    slow = slow.next;
                }
                return other;
            }
        }
        return null;
    }
}
