package linkedlist;

import java.util.Stack;

public class AddTwoNumbersV2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2);
                l2 = l2.next;
            }
        }
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b = stack2.isEmpty() ? 0 : stack2.pop().val;
            int cur = a + b + carry;
            carry = cur / 10;
            cur = cur % 10;
            ListNode newNode = new ListNode(cur);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
}
