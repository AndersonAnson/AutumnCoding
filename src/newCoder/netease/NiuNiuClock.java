package newCoder.netease;

import java.util.Arrays;
import java.util.Scanner;

public class NiuNiuClock {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] getUp = new int[N];
        int h, m;
        for (int i = 0; i < N; i++) {
            h = sc.nextInt();
            m = sc.nextInt();
            getUp[i] = h * 60 + m;
        }
        int roadTime = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int needGetUp = A * 60 + B - roadTime;
        Arrays.sort(getUp);
        int index = Arrays.binarySearch(getUp, needGetUp);
        if (index < 0) {
            index = -(index + 2);
        }
        h = getUp[index] / 60;
        m = getUp[index] % 60;
        System.out.println(h + " " + m);
    }
}
