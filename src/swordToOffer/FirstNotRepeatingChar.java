package swordToOffer;

public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        int[] hash = new int[256];// 用來存储每个字符的频率
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;// 字符到int的自动映射到256个位置
        }
        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
