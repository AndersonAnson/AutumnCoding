package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteV2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return res;
        LinkedList<Integer> tempRes = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, visited, tempRes);
        return res;
    }

    public void dfs(int[] nums, int depth, boolean[] visited, LinkedList<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // ��֦������i > 0 ��Ϊ�˱�֤ nums[i - 1] ������
                // д !used[i - 1] ����Ϊ nums[i - 1] ��������ȱ����Ĺ����иոձ�����ѡ��
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(nums, depth + 1, visited, path);
                // ע�⣺������״̬���ã��Ǵ������ص�ǳ����Ĺ��̣���������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
                path.removeLast();
                visited[i] = false;
            } else {
                continue;
            }
        }
    }
}
