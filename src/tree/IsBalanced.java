package tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (recur(root) == -1)
            return false;
        return true;
    }

    private int recur(TreeNode root) {
        if (root == null)
            return 0;
        int left = recur(root.left);
        if (left == -1)
            return -1;
        int right = recur(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
