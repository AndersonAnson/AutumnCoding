package tree;

import java.util.LinkedList;

class Node {
    public int val;
    public tree.Node left;
    public tree.Node right;
    public tree.Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, tree.Node _left, tree.Node _right, tree.Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Connect {
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node tempNode = queue.get(0);
            for (int i = 1; i < size; i++) {
                tempNode.next = queue.get(i);
                tempNode = queue.get(i);
            }
            for (int i = 0; i < size; i++) {
                tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
        }
        return root;
    }

    public Node connectV2(Node root) {
        if (root == null) {
            return root;
        }
        Node prev = root;
        //循环条件是当前节点的left不为空，当只有根节点
        //或所有叶子节点都出串联完后循环就退出了
        while (prev.left != null) {
            Node tempNode = prev;
            while (tempNode != null) {
                //将tmp的左右节点都串联起来
                //注:外层循环已经判断了当前节点的left不为空
                tempNode.left.next = tempNode.right;
                //下一个不为空说明上一层已经帮我们完成串联了
                if (tempNode.next != null) {
                    tempNode.right.next = tempNode.next.left;
                }
                //继续右边遍历
                tempNode = tempNode.next;
            }
            //从下一层的最左边开始遍历
            prev = prev.left;
        }
        return root;
    }

    public Node connectV3(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        //配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归的调用左右节点，完成同样的纵深串联
        dfs(left);
        dfs(right);
    }
}
