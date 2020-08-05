package tree;

import java.util.*;

public class DistanceK {
    HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null) {
            return res;
        }
        dfsFindParent(root, null);
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == K) {
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null && !visited.contains(tempNode.left)) {
                    queue.offer(tempNode.left);
                    visited.add(tempNode.left);
                }
                if (tempNode.right != null && !visited.contains(tempNode.right)) {
                    queue.offer(tempNode.right);
                    visited.add(tempNode.right);
                }
                TreeNode parent = hashMap.getOrDefault(tempNode, null);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }
        return res;
    }

    public void dfsFindParent(TreeNode children, TreeNode parent) {
        if (children == null) {
            return;
        } else {
            hashMap.put(children, parent);
            dfsFindParent(children.left, children);
            dfsFindParent(children.right, children);
        }
    }
}
