package linkedlist;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean ans = true;
        while (ans && p2 != null) {
            if (p1.val != p2.val)
                ans = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverse(secondHalfStart);
        return ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
