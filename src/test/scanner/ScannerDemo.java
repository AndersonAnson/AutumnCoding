package test.scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        next 我们只关注第一个默认的 next() 方法即可，它从遇到的第一个有效字符（非空格、非换行）开始扫描，直到遇到空格或者换行符。将这段内容以 String 返回。
//        next() 以空格符（换行符也行，这里不多写了）作为分割
        int matchNum = 1;
        while (in.hasNext()) {
            System.out.print("scan " + matchNum + " content：");
            System.out.println(in.next());
            matchNum++;
        }
//        nextLine 是以换行符作为分割点
        matchNum = 1;
        while (in.hasNextInt()) {
            System.out.print("scan " + matchNum + " content：");
            System.out.println(in.nextInt());
            matchNum++;
        }
    }
}
