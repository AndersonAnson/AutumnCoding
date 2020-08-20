package newCoder;

import java.util.Scanner;

public class NiuNiuMissWayV2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] dire = new String[]{"N", "E", "S", "W"};
        int n = in.nextInt();
        String s = in.next();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                ret++;
            } else {
                ret--;
            }
        }
        ret %= 4;
        if (ret < 0) {
            ret += 4;
        }
        System.out.println(dire[ret]);
    }
}
