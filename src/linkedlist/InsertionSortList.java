package linkedlist;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (end.val < cur.val) {
                end.next = cur;
                end = cur;
                cur = cur.next;
            } else {
                // �ȶ���һ�� tmp ָ�� cur ��һ������ֹ����
                ListNode temp = cur.next;
                // �Ͽ�Ҫ�ŵ�Ԫ��
                end.next = temp;
                // ��ͷ�ж��ҳ����ʵĲ���λ��
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                // �ҵ�����λ�ú�ֱ�ӽ�Ԫ�طŽ���
                cur.next = pre.next;
                pre.next = cur;
                // ��󽫶�λָ���Ϊ
                pre = dummy;
                cur = temp;
            }
        }
        return dummy.next;
    }
}
