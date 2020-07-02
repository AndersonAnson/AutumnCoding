package dp;

import tree.TreeNode;

import java.util.HashMap;

public class RobV3 {
    HashMap<TreeNode, Integer> memoMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memoMap.containsKey(root)) {
            return memoMap.get(root);
        }
        int toDo = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int noDo = rob(root.left) + rob(root.right);
        int res = Math.max(toDo, noDo);
        memoMap.put(root, res);
        return res;
    }
}
