package math;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        // 从后往前遍历两个字符串并计算依次拼接每一位。
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            // 只有两个字符串没有遍历完，就累加当前位置的数值。
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            carry = sum / 2;
        }
        ans.append(carry == 1 ? carry : "");
        return ans.reverse().toString();
    }
}
