package test.ali;

import java.util.LinkedList;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNum = in.nextInt();
        int tempN = 0, tempM = 0, tempNM = 0;
        boolean flag = true;
        int lengthN, lengthM;
        int[] n, m, nm;
        while (in.hasNextInt()){
            flag = true;
            lengthN = in.nextInt();
            lengthM = in.nextInt();
            n = new int[lengthN];
            m = new int[lengthM];
            nm = new int[lengthN + lengthM];
            LinkedList<Integer> listn = new LinkedList<>();
            LinkedList<Integer> listm = new LinkedList<>();
            LinkedList<Integer> listnm = new LinkedList<>();

            for (int i = 0; i < lengthN; i++) {
                n[i] = in.nextInt();
//                System.out.println(n[i]);
                listn.offer(n[i]);
            }
            for (int i = 0; i < lengthM; i++) {
                m[i] = in.nextInt();
//                System.out.println(m[i]);
                listm.offer(m[i]);
            }
            for (int i = 0; i < lengthM + lengthN; i++) {
                nm[i] = in.nextInt();
//                System.out.println(nm[i]);
                listnm.offer(nm[i]);
            }
            while (!listn.isEmpty() && !listm.isEmpty()) {
                if (flag == false) {
                    break;
                }
                tempNM = listnm.poll();
                tempN = listn.peek();
                tempM = listm.peek();
                if (tempN == tempNM) {
                    listn.poll();
                }
                if (tempM == tempNM) {
                    listm.poll();
                }
                if (tempN != tempNM && tempM != tempNM) {
                    flag = false;
                }
            }
            if (flag == false) {
                System.out.println("not possible");
            } else {
                System.out.println("possible");
            }
        }
    }
}