package swordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class StringPermutation {
//    排列组合中用过的字符不能再用，所以要用 boolean visited[] 来标记哪一个用过，用过了就不能再组合
//    题目说可能有重复字母，TreeSet 刚好存的值不能重复，所以用 TreeSet，假如用 List 存会存在：
//    S = "aa"
//    List = ["aa", "aa"]
//    第一个是第一个 a 开头的，第二个是第二个 a 开头的
    private ArrayList<String> res = new ArrayList<>();
    private TreeSet<String> paths = new TreeSet<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] visited;

    public ArrayList<String> permutation(String str) {
        if (str == null || str.equals("")) {
            return res;
        }
        char[] cha = str.toCharArray();
        Arrays.sort(cha);
        visited = new boolean[cha.length];
        combination(cha, 0);
        res.addAll(paths);
        return res;
    }

    public void combination(char[] arr, int len) {
        if (len == arr.length) {// 先一口气到底，加入一种情况
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path = path.append(arr[i]);
                combination(arr, len + 1);
                // 一口气到底之后在回溯的时候重置状态
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
