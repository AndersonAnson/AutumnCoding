package swordToOffer;

public class RegMatch {
    public boolean match(char[] str, char[] pattern) {
        // 检查边界
        if (str == null || pattern == null) {
            return false;
        }
        // 定义两个指针分别指向str和pattern
        int indexOfStr = 0;
        int indexOfPattern = 0;
        return matchHelper(str, indexOfStr, pattern, indexOfPattern);
    }

    public boolean matchHelper(char[] str, int indexOfStr, char[] pattern, int indexOfPattern) {
        // 判断边界条件,指针索引完成
        if (indexOfStr == str.length && indexOfPattern == pattern.length) {
            return true;
        }
        // indexOfPattern先到尾部则匹配失败
        if (indexOfPattern == pattern.length && indexOfStr < str.length) {
            return false;
        }
        // pattern的第二个字符为'*',且第一个字符匹配,边界为模式指针未达到末尾
        if (indexOfPattern + 1 < pattern.length && pattern[indexOfPattern + 1] == '*') {
            if ((indexOfStr != str.length && str[indexOfStr] == pattern[indexOfPattern])
                    || (indexOfStr != str.length && pattern[indexOfPattern] == '.')) {
                return matchHelper(str, indexOfStr, pattern, indexOfPattern + 2)
                        || matchHelper(str, indexOfStr + 1, pattern, indexOfPattern + 2)
                        || matchHelper(str, indexOfStr + 1, pattern, indexOfPattern);
            } else {
                // 第一个字符不匹配,pattern直接移动两位
                return matchHelper(str, indexOfStr, pattern, indexOfPattern + 2);
            }
        }
        // pattern的第二个字符不为'*',且第一个字符匹配
        if ((indexOfStr != str.length && str[indexOfStr] == pattern[indexOfPattern])
                || (indexOfStr != str.length && pattern[indexOfPattern] == '.')) {
            return matchHelper(str, indexOfStr + 1, pattern, indexOfPattern + 1);
        } else {
            // 第一个字符不匹配
            return false;
        }
    }
}
