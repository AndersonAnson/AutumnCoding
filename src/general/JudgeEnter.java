package general;

public class JudgeEnter {
    public int judgeEnter(int x) {
        int ans = 0;
        while (x != 0) {
            ans = ans + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
