package tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
