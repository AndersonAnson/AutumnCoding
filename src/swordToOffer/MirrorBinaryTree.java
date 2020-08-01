package swordToOffer;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBinaryTree {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归将两给子树的左右子树镜像
        Mirror(root.left);
        Mirror(root.right);
    }

    public void MirrorV2(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            for (int i = 0; i < len; i++) {
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if (curr.left != null) nodes.offer(curr.left);
                if (curr.right != null) nodes.offer(curr.right);
            }
        }
    }
}
