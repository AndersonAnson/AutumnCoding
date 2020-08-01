package swordToOffer;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
//     定义一个头结点指向旧链表
//     构造一个新节点指向新链表
//     采用头插法
        ListNode oldDummy = head;
        ListNode newDummy = new ListNode(0);
//     初始化一个新链表
        while (oldDummy != null) {
//       进行轮换
            ListNode temp = oldDummy.next;
            oldDummy.next = newDummy.next;
            newDummy.next = oldDummy;
            oldDummy = temp;
        }
        return newDummy.next;
    }

    public ListNode reverseListV2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
