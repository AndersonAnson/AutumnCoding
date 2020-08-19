package tree;

import java.util.ArrayList;

public class BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {
        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        this.inorder(root);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        this.nodesSorted.add(root.val);
        inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        this.index++;
        return this.nodesSorted.get(this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}
