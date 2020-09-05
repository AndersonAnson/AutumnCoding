package newCoder.netease;

import java.util.Scanner;

public class PutDumpOnRoad {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int roadLen = sc.nextInt();
            String roadCon = sc.next();
            int count = 0;
            for (int j = 0; j < roadLen; ) {
                if (roadCon.charAt(j) == '.') {
                    count++;
                    j = j + 3;//贪心算法
                } else {
                    j++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
