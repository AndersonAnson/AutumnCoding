package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesisV2(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // �������Ŷ���ʣ���ˣ��ݹ���ֹ
            res.add(curStr);
            return;
        }

        if (left > 0) { // ��������Ż�ʣ��Ļ�������ƴ��������
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // ���������ʣ�����������ʣ��Ļ�������ƴ��������
            dfs(left, right - 1, curStr + ")");
        }
    }
}
