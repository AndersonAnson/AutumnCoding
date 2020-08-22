package test.yuanfudao;

import java.util.Scanner;

public class MaxSubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matrix = new int[N][M];
        long[] rowSum = new long[N];
        long[] colSum = new long[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] sumMark = new int[N][M];
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sumMark[i][j] = sumMark[i][j] + sumMark[i - 1][j];
            }
        }
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int[] sumList = new int[M];
                for (int k = 0; k < M; j++) {
                    if (i == 0) {
                        sumList[k] = sumMark[j][k];
                    } else {
                        sumList[k] = sumMark[j][k] - sumMark[j - 1][k];
                    }
                }
                int maxRes = getNumber(sumList);
                sum = Math.max(sum, maxRes);
            }
        }
        System.out.println(sum);
    }

    public static int getNumber(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        int[] array = new int[arr.length];
        array[0] = arr[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] = array[i - 1] + arr[i];
            } else {
                array[i] = arr[i];
            }
            maxVal = Math.max(maxVal, array[i]);
        }
        return maxVal;
    }
}
