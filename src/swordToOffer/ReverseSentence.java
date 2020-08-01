package swordToOffer;

public class ReverseSentence {
    public String reverseSentence(String str) {
        if (str.length() <= 0) {
            return "";
        }
        // 反转整个句子
        StringBuffer st1 = new StringBuffer(str);
        st1.reverse();
        // 存放结果
        StringBuffer result = new StringBuffer();
        int j = 0;
        // 标记空格数
        int blankNum = 0;
        for (int i = 0; i < st1.length(); i++) {
            // 1、当有空格，且没有到达最后一个单词时
            if (st1.charAt(i) == ' ' && (i != st1.length() - 1)) {
                blankNum++;
                StringBuffer st2 = new StringBuffer(st1.substring(j, i));
                result.append(st2.reverse().toString()).append(" ");
                j = i + 1;
            }
            // 2、当有空格，且到达最后一个单词时
            if (blankNum != 0 && i == (st1.length() - 1)) {
                StringBuffer st3 = new StringBuffer(st1.substring(j, i + 1));
                result.append(st3.reverse());
            }
        }
        // 空格数为0时，直接返回原字符串
        if (blankNum == 0) {
            return str;
        }
        return result.toString();
    }
}
