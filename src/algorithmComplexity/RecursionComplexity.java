package algorithmComplexity;
//来看一下这道面试题：求x的n次方
public class RecursionComplexity {
//    时间复杂度为O(n)
    int function1(int x, int n) {
        int result = 1;  // 注意 任何数的0次方等于1
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

//    时间复杂度是 n * 1 = O(n)
    int function2(int x, int n) {
        if (n == 0) {
            return 1; // return 1 同样是因为0次方是等于1的
        }
        return function2(x, n - 1) * x;
    }

//    时间复杂度依然是O(n)
    int function3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return function3(x, n / 2) * function3(x, n / 2) * x;
        }
        return function3(x, n / 2) * function3(x, n / 2);
    }

//    时间复杂度才是真正的O(logn)
    int function4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int t = function4(x, n / 2);// 这里相对于function3，是把这个递归操作抽取出来
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }
}
