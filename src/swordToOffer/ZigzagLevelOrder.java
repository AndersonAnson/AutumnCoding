package swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> oneLevel = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (isReverse == false) {
                    oneLevel.add(node.val);
                } else {
                    oneLevel.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isReverse = !isReverse;
            res.add(oneLevel);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrderV2(TreeNode pRoot) {
        int layer = 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot != null) {
            q.add(pRoot);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = q.poll();
                if (tn == null)
                    continue;
                if (layer % 2 == 0) {
                    list.add(0, tn.val);
                } else {
                    list.add(tn.val);
                }
                q.offer(tn.left);
                q.offer(tn.right);
            }
            if (list.size() != 0) {
                res.add(list);
            }
            layer++;
        }
        return res;
    }
}
