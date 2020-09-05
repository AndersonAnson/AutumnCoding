package test.haoweilai;

import swordToOffer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class NotReCuPreOrder {
    public String notReCuPreOrder(TreeNode root) {
        // write code here
        StringBuilder s = new StringBuilder("");
        if (root == null) {
            return s.toString();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        linkedList.push(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.poll();
            s.append(treeNode.val + ",");
            if (treeNode.right != null) {
                linkedList.push(treeNode.right);
            }
            if (treeNode.left != null) {
                linkedList.push(treeNode.left);
            }
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }
}
