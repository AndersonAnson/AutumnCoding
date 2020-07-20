package math;

public class ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                c = 26;
                n = n - 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            n = n / 26;
        }
        return sb.toString();
    }

    public String convertToTitleV2(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--;//这里稍作处理，因为它是从1开始
            stringBuilder.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
