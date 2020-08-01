package swordToOffer;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;
//    定义一个快指针
//    定义一个慢指针
//    当快指针走了第k-1步时候 慢指针开始走
//    标记慢指针是否移动过
        int flag = 0;
        while (fast.next != null) {
            // 进行移动
            if (count == k) {
                flag = 1;
            }
            fast = fast.next;
            if (flag == 1) {
                slow = slow.next;
            }
            count++;
        }
        if (count < k) {
            return null;
        } else {
            return slow;
        }
    }
}
