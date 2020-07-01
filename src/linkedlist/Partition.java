package linkedlist;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode minDummy = new ListNode(-1);
        ListNode maxDummy = new ListNode(-2);
        ListNode mainCurremt = head;
        ListNode minCurrent = minDummy;
        ListNode maxCurrent = maxDummy;
        while (mainCurremt != null) {
            if (mainCurremt.val < x) {
                ListNode minNode = new ListNode(mainCurremt.val);
                minCurrent.next = minNode;
                minCurrent = minCurrent.next;
            } else {
                ListNode maxNode = new ListNode(mainCurremt.val);
                maxCurrent.next = maxNode;
                maxCurrent = maxCurrent.next;
            }
            mainCurremt = mainCurremt.next;
        }
        minCurrent.next = maxDummy.next;
        return minDummy.next;
    }
}
