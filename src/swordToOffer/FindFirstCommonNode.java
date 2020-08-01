package swordToOffer;

public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                // p1去phead2 调换位置再跑一遍
                // p2也是一样
                if (p1 == null)
                    p1 = pHead2;
                if (p2 == null)
                    p2 = pHead1;
            }
        }
        return p1;
    }

    public ListNode findFirstCommonNodeV2(ListNode pHead1, ListNode pHead2) {
//      找出两个链表的长度 然后让长的先走两个链表的长度差 然后再一起走
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        int pLen1 = 0;
        int pLen2 = 0;
        while (head1 != null) {
            pLen1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            pLen2++;
            head2 = head2.next;
        }
        head1 = pHead1;
        head2 = pHead2;
//     得到长度差值
        int lengthDiff = Math.abs(pLen1 - pLen2);
        int count = 0;
        if (pLen1 < pLen2 && count < lengthDiff) {
            count++;
            head2 = head2.next;
        } else if (pLen2 < pLen1 && count < lengthDiff) {
            count++;
            head1 = head1.next;
        }

        while (head1 != null || head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        while ((head1 != null) && (head2 != null) && (head1.val != head2.val)) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
}
