package linkedlist;

import tree.TreeNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode midListNode = findMiddleElement(head);
        TreeNode midTreeNode = new TreeNode(midListNode.val);
        if (head == midListNode) {
            return midTreeNode;
        }
        midTreeNode.left = sortedListToBST(head);
        midTreeNode.right = sortedListToBST(midListNode.next);
        return midTreeNode;
    }

    public ListNode findMiddleElement(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
