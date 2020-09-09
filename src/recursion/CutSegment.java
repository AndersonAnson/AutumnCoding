package recursion;

public class CutSegment {
    public static int res = 0;

    public static void findTypeNum(int N, int M) {
        //M==1跳出循环
        if (M == 1) {
            res++;
        }
//        第一刀可以切1到N-1米，然后还剩N-i米，要切M-1段。因此可以递归这一个通用操作
        for (int i = 1; i <= N - 1; i++) {
            findTypeNum(N - i, M - 1);
        }
    }

    public static void main(String[] args) {
        findTypeNum(5, 3);
        System.out.println(res);
    }
}
