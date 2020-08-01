package swordToOffer;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
//    定义一个新的结点
        ListNode list3 = new ListNode(0);
        ListNode head = list3;
        list3.next = null;
//    如果list1小于list2 那么加入list1 否则加入list2
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }
        if (list1 != null)
            list3.next = list1;
        if (list2 != null)
            list3.next = list2;
        return head.next;
    }

    //递归
    public ListNode mergeTwoListsV3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val < list2.val) {
                list1.next = mergeTwoListsV3(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoListsV3(list1, list2.next);
                return list2;
            }
        }
    }
}
