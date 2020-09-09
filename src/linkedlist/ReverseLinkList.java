package linkedlist;

public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }

    public ListNode reverseListV2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseListV2(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    public ListNode reverseListV3(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = dummy.next;
            dummy.next = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}
