package test.pdd;

import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int M = sc.nextInt();
        int[] valueSet = new int[M];
        for (int i = 0; i < M; i++) {
            valueSet[i] = sc.nextInt();
        }
    }

}
