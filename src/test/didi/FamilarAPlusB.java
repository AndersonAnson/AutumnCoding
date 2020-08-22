package test.didi;

import java.util.*;

public class FamilarAPlusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        int a = num / 200;
        int mark = a * 100;
        int mark2 = a * 100;
        int other = num % 200;
        int b = 0;
        int c = 0;
        while (b <= 9) {
            int all = other - 10 * b;
            if (all % 12 == 0 && all > 0) {
                c = all / 12;
                if (b != c) {
                    mark = mark + 10 * b + c;
                    mark2 = mark2 + 10 * c + c;
                    list.addLast(mark);
                    list.addLast(mark2);
                }
                c = 0;
            }
            b++;
        }
        System.out.println(list.size() / 2);
        Collections.sort(list);
        System.out.println(list);
    }
}
