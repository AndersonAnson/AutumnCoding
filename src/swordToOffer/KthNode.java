package swordToOffer;

import java.util.ArrayList;

public class KthNode {
    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode Kthnode(TreeNode pRoot, int k) {
        this.inOrder(pRoot);
        if (k >= 1 && k <= list.size()) {
            return list.get(k - 1);
        }
        return null;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root);
        if (root.right != null) {
            inOrder(root.right);
        }
    }
}
