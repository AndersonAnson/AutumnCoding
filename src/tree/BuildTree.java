package tree;

import java.util.HashMap;

public class BuildTree {
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data");
        }
        for (int i = 0; i < inLen; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildHelper(preorder, 0, preLen - 1, 0, inLen - 1);
    }

    private TreeNode buildHelper(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode rootNode = new TreeNode(rootVal);
        int pIndex = indexMap.get(rootVal);
        int sizeLeftSubTree = pIndex - inLeft;
        rootNode.left = buildHelper(preorder, preLeft + 1, preLeft + sizeLeftSubTree, inLeft, pIndex - 1);
        rootNode.right = buildHelper(preorder, preLeft + sizeLeftSubTree + 1, preRight, pIndex + 1, inRight);
        return rootNode;
    }

}
