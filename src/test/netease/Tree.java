package test.netease;

import java.util.HashMap;
import java.util.Scanner;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int x) {
        val = x;
    }
}

public class Tree {
    public static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer, Node> hashMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            Node node = new Node(i);
            hashMap.put(i, node);
        }
        for (int i = 0; i < n; i++) {
            int parentId = sc.nextInt();
            Node parentNode = hashMap.get(parentId);
            String dicrection = sc.next();
            int childrenId = sc.nextInt();
            Node childNode = hashMap.get(childrenId);
            if (dicrection.equals("left")) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }
        Node root = hashMap.get(1);

        dfs(root);
        System.out.println(res);
    }

    public static void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (isLeaf(root.left) && isLeaf(root.right)) {
            res++;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public static boolean isLeaf(Node root) {
        if (root != null && root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }
}
