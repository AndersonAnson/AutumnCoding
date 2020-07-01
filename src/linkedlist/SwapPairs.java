package linkedlist;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // 1. 终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了
        if (head == null || head.next == null) {
            return head;
        }
        // 2. 调用单元，需要交换的两个节点是 head 和 head.
        ListNode firstNode = head;
        ListNode nextNode = head.next;
        // firstNode 连接后面交换完成的子链表
        firstNode.next = swapPairs(nextNode.next);
        // secondNode 连接 firstNode
        nextNode.next = head;
        // 3. 返回值：返回交换完成的子链表 secondNode 变成了头结点
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
