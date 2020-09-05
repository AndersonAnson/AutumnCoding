package test.sougou;

import swordToOffer.MatrixHasPath;

import java.util.HashSet;

public class GetPasswordCount {
    public static void main(String[] args) {
        System.out.println(new GetPasswordCount().getPasswordCount("12345"));
    }

    public long getPasswordCount(String password) {
        // write code here
        int start = 0;
        StringBuilder s = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        String tempWord = "";
        for (; start <= 9; start++) {
            tempWord = "";
            tempWord = s.append(start).toString();
            dfs(password, tempWord, set, 1);
        }
        return set.size();
    }

    public void dfs(String password, String tempWord, HashSet<String> set, int index) {
        if (password.length() == tempWord.length()) {
            set.add(tempWord);
            return;
        }
        StringBuilder sb = new StringBuilder(tempWord);
        Integer sum = tempWord.charAt(index - 1) - 48 + password.charAt(index) - 48;
        double floor = Math.floor(sum / 2);
        double ceil = Math.ceil(sum / 2);
        index++;
        if (floor == ceil) {
            tempWord = sb.append((int) floor).toString();
            dfs(password, tempWord, set, index);
        } else {
            tempWord = sb.append((int) floor).toString();
            dfs(password, tempWord, set, index);
            tempWord = sb.append((int) ceil).toString();
            dfs(password, tempWord, set, index);
        }
    }
}
