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
        //�ݹ���ֹ�����ǵ�ǰΪ�գ�������һ���ڵ�Ϊ��
        if (head == null || head.next == null) {
            return head;
        }
        //�����cur�������һ���ڵ�
        ListNode cur = reverseListV2(head.next);
        //��������϶�����ʾ���
        //��������� 1->2->3->4->5����ô��ʱ��cur����5
        //��head��4��head����һ����5������һ���ǿ�
        //����head.next.next ����5->4
        head.next.next = head;
        //��ֹ����ѭ������Ҫ��head.next����Ϊ��
        head.next = null;
        //ÿ��ݹ麯��������cur��Ҳ�������һ���ڵ�
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
