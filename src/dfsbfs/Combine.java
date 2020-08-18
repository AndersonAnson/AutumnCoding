package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, res, new LinkedList<>(), n, k);
        return res;

    }

    public void dfs(int start, List<List<Integer>> res, LinkedList<Integer> tempList, int n, int k) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            dfs(i + 1, res, tempList, n, k);
            tempList.removeLast();
        }
    }

    public List<List<Integer>> combineV2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        findCombinations(n, k, 1, res, new Stack<>());
        return res;
    }

    // p 可以声明成一个栈
    // i 的极限值满足： n - i + 1 = (k - pre.size())。
    // 【关键】n - i + 1 是闭区间 [i,n] 的长度。
    // k - pre.size() 是剩下还要寻找的数的个数。
    private void findCombinations(int n, int k, int start, List<List<Integer>> res, Stack<Integer> preStack) {
        if (preStack.size() == k) {
            res.add(new ArrayList<>(preStack));
            return;
        }
        for (int i = start; i <= n - (k - preStack.size()) + 1; i++) {
            preStack.push(i);
            findCombinations(n, k, i + 1, res, preStack);
            preStack.pop();
        }
    }
}
