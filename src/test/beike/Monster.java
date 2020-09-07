package test.beike;

import java.util.Scanner;

public class Monster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int all = 2 * n;
        int[] decrease = new int[2 * n];
        int[] increase = new int[2 * n];

        for (int i = 0; i < all; i++) {
            decrease[i] = sc.nextInt();
        }
        for (int i = 0; i < all; i++) {
            increase[i] = sc.nextInt();
        }
        int[] cutValue = new int[2 * n];
        for (int i = 0; i < all; i++) {
            cutValue[i] = increase[i] - decrease[i];
        }
        int left = (all - 1) / 2;
        int right = all / 2;
        int lifeValue = Math.min(decrease[left], decrease[right]) + 1;
        while (left >= 0 && right <= all - 1) {
            if (cutValue[left] >= cutValue[right]) {
                if (cutValue[left] >= 0) {
                    lifeValue = lifeValue + cutValue[left];
                } else {
                    lifeValue = lifeValue - Math.abs(cutValue[left]);
                }
                left--;
            } else {
                if (cutValue[right] >= 0) {
                    lifeValue = lifeValue + cutValue[right];
                } else {
                    lifeValue = lifeValue - Math.abs(cutValue[right]);
                }
                right++;
            }
        }
        while (left >= 0) {
            if (cutValue[left] >= 0) {
                lifeValue = lifeValue + cutValue[left];
            } else {
                lifeValue = lifeValue - Math.abs(cutValue[left]);
            }
            left--;
        }
        while (right <= all - 1) {
            if (cutValue[right] >= 0) {
                lifeValue = lifeValue + cutValue[right];
            } else {
                lifeValue = lifeValue - Math.abs(cutValue[right]);
            }
            right++;
        }
        int res = 1;
        if (lifeValue <= 0) {
            res = Math.abs(lifeValue) + 1;
        } else {
            res = 1;
        }
        System.out.println(res);
    }
}
