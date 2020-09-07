package test.beike;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] strs = new String[4];
        while (T > 0) {
            for (int i = 0; i < 4; i++) {
                strs[i] = sc.next();
            }
            int score = 0;
            ArrayList<Integer> allScore = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                String niumei = strs[i];
                score = 0;
                for (int j = 2; j < 4; j++) {
                    String niuniu = strs[j];
                    if (niumei.equals("S") && niuniu.equals("J")) {
                        score++;
                    } else if (niumei.equals("S") && niuniu.equals("B")) {
                        score--;
                    } else if (niumei.equals("S") && niuniu.equals("S")) {
                        score--;
                    } else if (niumei.equals("J") && niuniu.equals("B")) {
                        score++;
                    } else if (niumei.equals("J") && niuniu.equals("S")) {
                        score--;
                    } else if (niumei.equals("J") && niuniu.equals("J")) {
                        score--;
                    } else if (niumei.equals("B") && niuniu.equals("J")) {
                        score--;
                    } else if (niumei.equals("B") && niuniu.equals("S")) {
                        score++;
                    } else if (niumei.equals("B") && niuniu.equals("B")) {
                        score--;
                    }
                }
                allScore.add(score);
            }
            int left = allScore.get(0);
            int right = allScore.get(1);
            if (left > right) {
                System.out.println("left");
            } else if (left < right) {
                System.out.println("right");
            } else {
                System.out.println("same");
            }
            allScore.clear();
            T--;
        }
    }
}
