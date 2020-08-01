package swordToOffer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    ArrayList<Integer> list = new ArrayList();

    public ArrayList<Integer> printListFromTailToHeadV2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHeadV2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
