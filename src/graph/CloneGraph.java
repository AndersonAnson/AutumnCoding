package graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> seen = new HashMap<>();
        return dfs(node, seen);
    }

    private Node dfs(Node node, Map<Node, Node> seen) {
        if (node == null) {
            return null;
        }
        if (seen.containsKey(node)) {
            return seen.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        seen.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, seen));
        }
        return clone;
    }

    public Node cloneGraphV2(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> seen = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        seen.put(node, clone);
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(node);
        while (!deque.isEmpty()) {
            Node temp = deque.poll();
            for (Node n : temp.neighbors) {
                if (!seen.containsKey(n)) {
                    seen.put(n, new Node(n.val, new ArrayList<>()));
                    deque.offer(n);
                }
                seen.get(temp).neighbors.add(seen.get(n));
            }
        }
        return clone;
    }
}
