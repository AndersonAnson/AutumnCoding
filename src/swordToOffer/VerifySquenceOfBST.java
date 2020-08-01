package swordToOffer;

public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence) {
//       结合图中分析：
//       一棵 BST ：左孩子 < 根结点 < 右孩子
//       一棵 BST 的左子树或者右子树都是 BST
//       后序遍历是，左右根：[3, 4, 9, 5, 12, 11, 10]，结合图再从左往右分析后序序列，分析子树，可以发现：
//       [3, 4, 9, 5] 10 [12, 11]
//       [3, 4] 5 [9]
//       [3] 4
//       [12] 11
//       发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数
//       那么，只需要不断地确定出左子树区间和右子树区间，并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，这个条件是否满足即可
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    boolean isBST(int[] arr, int start, int root) {
        if (start >= root) {
            return true;
        }
        int key = arr[root];
        int i;
        // 找到左右子树的分界点
        for (i = start; i < root; i++) {
            if (arr[i] > key) {
                break;
            }
        }
        // 在右子树中判断是否含有小于root的值，如果有返回false
        for (int j = i; j < root; j++) {
            if (arr[j] < key) {
                return false;
            }
        }
        return isBST(arr, start, i - 1) && isBST(arr, i, root - 1);
    }
}
