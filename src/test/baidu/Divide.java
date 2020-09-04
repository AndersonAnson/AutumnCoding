package test.baidu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp == 0) {
                if (hashMap.containsKey(0)) {
                    int num = hashMap.get(0);
                    num++;
                    hashMap.put(0, num);
                } else {
                    hashMap.put(0, 1);
                }
            }
            if (temp == 5) {
                if (hashMap.containsKey(5)) {
                    int num = hashMap.get(5);
                    num++;
                    hashMap.put(5, num);
                } else {
                    hashMap.put(5, 1);
                }
            }
        }
        System.out.println(hashMap.get(0));
        System.out.println(hashMap.get(5));
        if (hashMap.get(0) == 0) {
            System.out.println(-1);
        }
        StringBuilder sb = new StringBuilder("");

    }
}
