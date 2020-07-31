package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, "");
        return res;
    }

    public void dfs(TreeNode node, List<String> res, String path) {
        if (node != null) {
            path = path + String.valueOf(node.val);
            if (node.left == null && node.right == null) {
                res.add(path);
            } else {
                path = path + "->";
                dfs(node.left, res, path);
                dfs(node.right, res, path);
            }
        }
    }
}