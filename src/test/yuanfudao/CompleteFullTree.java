package test.yuanfudao;

import java.util.LinkedList;
import java.util.Scanner;

public class CompleteFullTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> tree = new LinkedList<>();
        int[] treeList = new int[n];
        boolean[][] visitedList = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            treeList[i] = sc.nextInt();
        }
    }
}
