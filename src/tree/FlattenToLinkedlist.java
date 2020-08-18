package tree;

import java.util.Deque;
import java.util.LinkedList;

public class FlattenToLinkedlist {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    public void flattenV2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode tempNode = curr.left;
                TreeNode prev = tempNode;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.left = null;
                curr.right = tempNode;
            }
            curr = curr.right;
        }
    }
}
