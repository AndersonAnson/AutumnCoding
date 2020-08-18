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
        // �����ԭ�����ڻ��ݵ�ʱ��Ƚ����׼�֦
        Arrays.sort(candidates);
        List<Integer> tempRes = new ArrayList<>();
        // ��������Ĺ�ʽ��candidates��ָѡ���б�target�����ж��Ƿ�����Լ����ڼ�֦
        // tempRes����·�������Ѿ�������ѡ��
        dfs(0, candidates, target, tempRes);
        return res;
    }

    public void dfs(int start, int[] candidates, int target, List<Integer> tempRes) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            // ��target����0��ʱ�򣬽�·�����뵽����б���
            res.add(new ArrayList<>(tempRes));
            return;
        }
        // ����ѡ���б�����û��ȥ��
        //���������start��ÿ�εݹ��ʱ��ֻ��candidates�е�ǰ��֮���������ѡ��
        for (int i = start; i < candidates.length; i++) {
            // ���������ĺô�������ֱ��������֦�����򻹵ñ���
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
