package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumV2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return res;
        }
        LinkedList<Integer> tempRes = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, tempRes);
        return res;
    }

    public void dfs(int start, int[] candidates, int target, LinkedList<Integer> tempRes) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new LinkedList<>(tempRes));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                //����Ե�ǰ���Ϊͷ����������϶������ˣ���ô��һ����������ͬ��ͷ���Ͳ���ȥ���ˡ�
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                tempRes.addLast(candidates[i]);
                dfs(i + 1, candidates, target - candidates[i], tempRes);
                tempRes.removeLast();
            }
        }
    }
}
