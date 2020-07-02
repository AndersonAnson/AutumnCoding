package tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0)
            return dp[0];
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            //将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1; root <= len; root++) {
                int left = root - 1;
                int right = len - root;
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        treeRoot.right = clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
