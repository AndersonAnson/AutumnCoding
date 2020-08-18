package dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int j = start; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(nums, path, j + 1);
            path.remove(path.size() - 1);
        }
    }
}
