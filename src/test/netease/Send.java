package test.netease;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode(int val) {
        this.val = val;
        neighbors = new ArrayList<GraphNode>();
    }
}

public class Send {
    public static int res;
    public static HashMap<GraphNode, GraphNode> seen = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] s = new int[n - 1];
        HashMap<Integer, GraphNode> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            GraphNode tempNode = new GraphNode(i);
            hashMap.put(i, tempNode);
        }
        for (int i = 0; i <= s.length - 1; i++) {
            s[i] = sc.nextInt();
            int num = i + 1;
            GraphNode graphNode = hashMap.get(num);
            GraphNode neigh = hashMap.get(s[i]);
            graphNode.neighbors.add(neigh);
            neigh.neighbors.add(graphNode);
        }
        GraphNode start = hashMap.get(0);
        dfs(start, k);
        System.out.println(res);
    }

    public static void dfs(GraphNode root, int k) {
        if (root == null || k == 0) {
            return;
        }

        for (GraphNode n : root.neighbors) {
            res++;
            dfs(n, k - 1);
            res--;
        }
    }
}
