package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        postorderHelper(root, response);
        return response;
    }

    public void postorderHelper(TreeNode root, List<Integer> response) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, response);
        postorderHelper(root.right, response);
        response.add(root.val);
    }

    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> response = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                response.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.left;
            }
        }
        return response;
    }
}
