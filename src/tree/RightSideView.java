package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode thisNode = queue.pop();
                if (thisNode.left != null) {
                    queue.add(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.add(thisNode.right);
                }
                if (i == size - 1) {
                    res.add(thisNode.val);
                }
            }

        }
        return res;
    }

    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }
}
