package test.yuanfudao;

import java.util.LinkedList;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int coinNum = 0;
        if (n % 2 == 0) {
            int i = n - 1;
            while (k > 0) {
                i = i - 2;
                k--;
            }
            for (int j = 1; j <= i; j = j + 2) {
                coinNum = coinNum + j;
            }
        } else {
            int i = n - 1;
            while (k > 0) {
                i = i - 2;
                k--;
            }
            for (int j = 2; j <= i; j = j + 2) {
                coinNum = coinNum + j;
            }
        }
        System.out.println(coinNum);
    }
}
