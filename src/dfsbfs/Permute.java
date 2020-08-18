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
//            如果写成res.add(path);就会输出[[], [], [], [], [], []],
//            因为java是值传递,对象类型传递的是地址,
//            因为path会被剪枝,而且path这个变量最后回到根节点变为[]
//            所以就会打印出来6个空
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(nums, depth + 1, visited, path);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                path.removeLast();
                visited[i] = false;
            }
        }
    }

//    不用回溯的方法
    public void dfsV2(int[] nums, int depth, boolean[] visited, LinkedList<Integer> path) {
        if (depth == nums.length) {
            res.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                LinkedList<Integer> newPath = new LinkedList<>(path);
                newPath.add(nums[i]);
                boolean[] newUsed = new boolean[nums.length];
                System.arraycopy(visited, 0, newUsed, 0, nums.length);
                newUsed[i] = true;
                dfsV2(nums, depth + 1, newUsed, newPath);
                // 2、无需回溯
            }
        }
    }
}
