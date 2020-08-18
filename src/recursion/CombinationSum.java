package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return res;
        }
        // 排序的原因是在回溯的时候比较容易剪枝
        Arrays.sort(candidates);
        List<Integer> tempRes = new ArrayList<>();
        // 套用上面的公式，candidates是指选择列表，target用来判断是否结束以及用于剪枝
        // tempRes则是路径，即已经做出的选择
        dfs(0, candidates, target, tempRes);
        return res;
    }

    public void dfs(int start, int[] candidates, int target, List<Integer> tempRes) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            // 当target等于0的时候，将路径加入到结果列表中
            res.add(new ArrayList<>(tempRes));
            return;
        }
        // 遍历选择列表，这里没有去重
        //下面会设置start，每次递归的时候只在candidates中当前及之后的数字中选择。
        for (int i = start; i < candidates.length; i++) {
            // 这就是排序的好处，可以直接这样剪枝，否则还得遍历
            if (candidates[i] > target) {
                break;
            }
            int temp = candidates[i];
            tempRes.add(temp);
            dfs(i, candidates, target - temp, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }
    }
}
