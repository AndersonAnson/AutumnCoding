package tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            int parentVal = node.val;
            if (p.val > parentVal && q.val > parentVal) {
                node = node.right;
            } else if (p.val < parentVal && q.val < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
