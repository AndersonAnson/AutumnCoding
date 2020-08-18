package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        LinkedList<Integer> tempRes = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, visited, tempRes);
        return res;
    }

    public void dfs(int[] nums, int depth, boolean[] visited, LinkedList<Integer> path) {
        if (depth == nums.length) {
//            ���д��res.add(path);�ͻ����[[], [], [], [], [], []],
//            ��Ϊjava��ֵ����,�������ʹ��ݵ��ǵ�ַ,
//            ��Ϊpath�ᱻ��֦,����path����������ص����ڵ��Ϊ[]
//            ���Ծͻ��ӡ����6����
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(nums, depth + 1, visited, path);
                // ע�⣺������״̬���ã��Ǵ������ص�ǳ����Ĺ��̣���������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
                path.removeLast();
                visited[i] = false;
            }
        }
    }

//    ���û��ݵķ���
    public void dfsV2(int[] nums, int depth, boolean[] visited, LinkedList<Integer> path) {
        if (depth == nums.length) {
            res.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // 1��ÿһ�γ��Զ������µı�����ʾ��ǰ��"״̬"
                LinkedList<Integer> newPath = new LinkedList<>(path);
                newPath.add(nums[i]);
                boolean[] newUsed = new boolean[nums.length];
                System.arraycopy(visited, 0, newUsed, 0, nums.length);
                newUsed[i] = true;
                dfsV2(nums, depth + 1, newUsed, newPath);
                // 2���������
            }
        }
    }
}
