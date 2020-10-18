package test.chinaMobile;

import java.util.Scanner;

public class Book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNum = 0;
        int N = sc.nextInt();
        int eachNum = 0;
        if (N == 1) {
            eachNum = 4;
            totalNum = 4;
            System.out.println(totalNum);
            System.out.println(eachNum);

        } else {
            totalNum = (int) Math.pow(2, N + 2);
            System.out.println(totalNum);
            N = N + 1;
            while (N > 1) {
                eachNum = Integer.valueOf((int) Math.pow(2, N));
                System.out.println(eachNum);
                N--;
            }
        }
    }
}
