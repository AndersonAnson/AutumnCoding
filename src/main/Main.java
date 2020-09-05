package main;

public class Main {
    public static void main(String[] args) {
        String a = "TALString";
        StringBuffer b = new StringBuffer("TALStringBuffer");
        methodA(a);
        methodB(b);
        System.out.println(a);
        System.out.println(b);
        byte c = 3;
        int d = 'c';
        double e = 0.2;

        System.out.println(c);
    }

    public static void methodA(String a) {
        a = new String("new TALString");
    }

    public static void methodB(StringBuffer a) {
        a = new StringBuffer("new TALStringBuffer");
    }
}
