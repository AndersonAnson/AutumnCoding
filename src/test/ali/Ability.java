package test.ali;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ability {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(Integer.MAX_VALUE);
        int n = in.nextInt();
        int[] ability = new int[n];
        for (int i = 0; i < ability.length; i++) {
            ability[i] = in.nextInt();
        }
        int[] dp = new int[n];
        for (int k = 1; k <= n; k++) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> (a - b));
            for (int j = 0; j < ability.length; j++) {
                heap.add(ability[j]);
            }
            dp[k - 1] = heap.peek();
        }

    }
}
