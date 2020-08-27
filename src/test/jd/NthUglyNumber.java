package test.jd;

import java.util.LinkedList;
import java.util.Scanner;

public class NthUglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] num = {'2', '3', '5'};
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();
        queue.offerLast("");
        int flag = 0;
        while (!queue.isEmpty()) {
            if (flag >= n) {
                break;
            }
            int size = queue.size();
            String tempString = queue.poll();
            for (int i = 0; i < num.length; i++) {
                String str = tempString + num[i];
                queue.offerLast(str);
                res.offerLast(str);
                flag++;
            }
        }
        System.out.println(Integer.valueOf(res.get(n - 1)));
    }
}
