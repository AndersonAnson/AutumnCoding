package swordToOffer;

public class TreeMaxDepth {
    public int TreeDepth(TreeNode root) {
//    思路 从根结点开始找路径 碰到叶子结点就形成了树的路径 然后把路径与最大值替换
        if (root == null) {
            return 0;
        }
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);
        return Math.max(nLeft, nRight) + 1;
    }
}
