package test;

import java.util.LinkedList;
import java.util.Scanner;

public class FibonacciSnake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] matrix = new long[n][n];
        int allNum = n * n;
        LinkedList<Long> list = new LinkedList<>();
        getNumber(allNum, list);
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (!list.isEmpty()) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = list.pollLast();
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = list.pollLast();
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = list.pollLast();
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = list.pollLast();
            }
            left++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1)
                    System.out.print(matrix[i][j]);
                else
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void getNumber(int n, LinkedList<Long> list) {
        long a = 0;
        long b = 1;
        long c = 0;
        list.offerFirst(1L);
        for (int i = 2; i <= n; i++) {
            c = a + b;
            list.offerLast(c);
            a = b;
            b = c;
        }
    }
}
