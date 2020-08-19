package test;

import java.util.Scanner;

public class ScannerV11 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            long a=in.nextLong();
            long b=in.nextLong();
            System.out.println(a+b);
        }
    }
}
