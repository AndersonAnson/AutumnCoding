package tree;

import linkedlist.ListNode;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);
        boolean levelOrder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                levelList.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            if (levelOrder == true) {
                res.add(levelList);
            } else {
                Collections.reverse(levelList);
                res.add(levelList);
            }
            levelOrder = !levelOrder;
        }
        return res;
    }
}
