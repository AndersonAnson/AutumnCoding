package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        preorderHelper(root, response);
        return response;
    }

    public void preorderHelper(TreeNode root, List<Integer> response) {
        if (root == null) {
            return;
        }
        response.add(root.val);
        preorderHelper(root.left, response);
        preorderHelper(root.right, response);
    }

    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        if (root == null) {
            return response;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            response.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return response;
    }
}
