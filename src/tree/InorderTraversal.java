package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        inorderHelper(root, response);
        return response;
    }

    public void inorderHelper(TreeNode root, List<Integer> response) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, response);
        response.add(root.val);
        inorderHelper(root.right, response);
    }

    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            response.add(curr.val);
            curr = curr.right;
        }
        return response;
    }
}
