package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsV2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int j = start; j < nums.length; j++) {
            //和上个数字相等就跳过
            if (j > start && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            dfs(nums, path, j + 1);
            path.remove(path.size() - 1);
        }
    }
}
