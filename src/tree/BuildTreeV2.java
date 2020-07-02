package tree;

import java.util.HashMap;

public class BuildTreeV2 {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new RuntimeException("Incorrect input data");
        }
        for (int i = 0; i < inLen; i++) {
            indexMap.put(inorder[i], i);
        }
        post = postorder;
        return buildHelper(0, inLen - 1, 0, postLen - 1);
    }

    private TreeNode buildHelper(int inLeft, int inRight, int postLeft, int postRight) {
        if (inRight < inLeft || postRight < postLeft)
            return null;
        int rootVal = post[postRight];
        int pIndex = indexMap.get(rootVal);
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = buildHelper(inLeft, pIndex - 1, postLeft, postLeft + pIndex - inLeft - 1);
        rootNode.right = buildHelper(pIndex + 1, inRight, postLeft + pIndex - inLeft, postRight - 1);
        return rootNode;
    }
}
