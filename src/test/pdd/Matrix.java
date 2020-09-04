package test.pdd;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        double cut = n / 2;
        if (n % 2 == 0) {

        }
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j > cut && i < cut) {
                    matrix[i][j] = 1;
                } else if (j < cut && i < cut && i < j) {
                    matrix[i][j] = 2;
                } else if (j < cut && i < cut && i > j) {
                    matrix[i][j] = 3;
                } else if (j < cut && i > cut) {
                    matrix[i][j] = 3;
                } else if (j > cut && i > cut) {
                    matrix[i][j] = 4;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
