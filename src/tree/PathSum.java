package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        if (root == null)
            return ans;
        helper(root, sum, ans, tempList);
        return ans;
    }

    // 传入4个参数来完成路径的存放和搜索
    public void helper(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> tempList) {
        if (root == null)
            return;
        tempList.add(root.val);
        // 如果只有根节点或只有叶子结点，则直接放入 ans 中
        if (root.left == null && root.right == null) {
            // 这里使用 new 的形式是因为初始化后,传进来的数据每次都是更新后的 tmp
            if (sum - root.val == 0) {
                ans.add(new ArrayList<>(tempList));
            }
        }
        helper(root.left, sum - root.val, ans, tempList);
        helper(root.right, sum - root.val, ans, tempList);
        // 这里利用了回溯的思想:每次回退上一个节点再寻找另一条边的节点作为新路径
        tempList.remove(tempList.size() - 1);
    }
}
