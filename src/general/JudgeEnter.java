package general;

public class JudgeEnter {
    public static void main(String[] args) {
//        int a=3;
//        switch (a){
//            case 1:
//                System.out.println(1);

    }

    public int judgeEnter(int x) {
        int ans = 0;
        while (x != 0) {
            ans = ans + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
