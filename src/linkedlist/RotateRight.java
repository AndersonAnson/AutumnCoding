package linkedlist;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        cur.next = head;
        k = k % len;
        cur = head;
        int move = len - k - 1;
        int i = 0;
        while (i < move) {
            cur = cur.next;
            i++;
        }
        ListNode ans = cur.next;
        cur.next = null;
        return ans;
    }
}
