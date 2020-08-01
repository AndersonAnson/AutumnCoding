package swordToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class LastRemainingGame {
    public int lastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        m = m - 1;
        int count = 0;
        Deque<Integer> q = new ArrayDeque<>(n);//用双端队列
        for (int i = 0; i < n; i++) {
            q.offerLast(i);// 记录每个孩子的编号
        }
        while (q.size() > 1) {
            if (count == m) {
                q.pollFirst();
                count = 0;
            }
            q.offerLast(q.pollFirst());
            count++;
        }
        return q.getFirst();
    }
}
