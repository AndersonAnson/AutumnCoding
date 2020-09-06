package test.tencent;

import java.util.Scanner;
import java.util.*;

public class MiddleNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
//            linkedList.addLast(sc.nextInt());
            arrayList.add(sc.nextInt());
//            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int removeNum = arrayList.remove(i);
            ArrayList<Integer> newList = new ArrayList<>(arrayList);
            Collections.sort(newList);
            System.out.println(newList.get((n - 2) / 2));
            arrayList.add(i, removeNum);
        }
//        double pivot = (double) (n - 1) / 2;
//        int res1 = arr[(int) Math.ceil(pivot)];
//        int res2 = arr[(int) Math.floor(pivot)];
//        for (int i = 0; i < n; i++) {
//            double temp = i;
//            if (temp < pivot) {
////                System.out.println(linkedList.get(n / 2));
////                System.out.println(arrayList.get((int) Math.ceil(pivot)));
////                System.out.println(arr[(int) Math.ceil(pivot)]);
//                System.out.println(res1);
//            } else {
////                System.out.println(arrayList.get((int) Math.floor(pivot)));
////                System.out.println(arr[(int) Math.floor(pivot)]);
//                System.out.println(res2);
//            }
//        }
    }
}
