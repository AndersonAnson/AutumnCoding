package linkedlist;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // 1. ��ֹ��������ǰû�нڵ����ֻ��һ���ڵ㣬�϶��Ͳ���Ҫ������
        if (head == null || head.next == null) {
            return head;
        }
        // 2. ���õ�Ԫ����Ҫ�����������ڵ��� head �� head.
        ListNode firstNode = head;
        ListNode nextNode = head.next;
        // firstNode ���Ӻ��潻����ɵ�������
        firstNode.next = swapPairs(nextNode.next);
        // secondNode ���� firstNode
        nextNode.next = head;
        // 3. ����ֵ�����ؽ�����ɵ������� secondNode �����ͷ���
        return nextNode;
    }

    public ListNode swapPairsV2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode nextNode = head.next;
            //swap
            prevNode.next = nextNode;
            firstNode.next = nextNode.next;
            nextNode.next = firstNode;
            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
