package tree;

public class DiameterOfBinaryTree {
    int maxResponse = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxResponse;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        maxResponse = Math.max(maxResponse, leftDepth + rightDepth);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(leftDepth, rightDepth) + 1;//返回节点深度
    }
}
