package linkedlist;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

public class CopyRandomList {
    HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }
        Node newNode = new Node(head.val, null, null);

        visitedHash.put(head, newNode);
        newNode.next = this.copyRandomList(head.next);
        newNode.random = this.copyRandomList(head.random);
        return newNode;
    }
}
