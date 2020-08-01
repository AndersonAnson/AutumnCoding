package swordToOffer;

import java.util.LinkedList;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return judge(left.left, right.right) && judge(left.right, right.left);
        }
    }

    boolean isSymmetricV2(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        LinkedList<TreeNode> leftList = new LinkedList<>();
        LinkedList<TreeNode> rightList = new LinkedList<>();
        leftList.add(pRoot.left);
        rightList.add(pRoot.right);
        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            TreeNode leftNode = leftList.poll();
            TreeNode rightNode = rightList.poll();
            if (leftNode == null && rightNode == null)
                continue;
            if (leftNode == null || rightNode == null)
                return false;
            if (leftNode.val != rightNode.val)
                return false;
            // 左子树从左往右添加节点
            leftList.add(leftNode.left);
            leftList.add(leftNode.right);
            // 右子树从右往左添加节点
            rightList.add(rightNode.right);
            rightList.add(rightNode.left);
        }
        return leftList.isEmpty() && rightList.isEmpty();
    }
}
