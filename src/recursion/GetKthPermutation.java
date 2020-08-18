package recursion;

import java.util.ArrayList;

public class GetKthPermutation {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] used = new boolean[n];//记录当前的索引的数是否被使用过
        return dfs(nums, new ArrayList<String>(), used, 0, n, k);
    }

    /**
     * @param nums      源数组
     * @param levelList 每一层的选择
     * @param used      数组的元素是否被使用过
     * @param depth     深度，也就是当前使用的元素的索引
     * @param n         上限值
     * @param k         第k个
     * @return 第k个排列
     */
    private String dfs(int[] nums, ArrayList<String> levelList, boolean[] used, int depth, int n, int k) {
        if (depth == n) {//触发出口条件，开始收集结果集
            StringBuilder sb = new StringBuilder();
            for (String s : levelList) {
                sb.append(s);
            }
            return sb.toString();
        }
        int cur = factorial(n - depth - 1);//当前的depth也就是索引，有多少排列数
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;//当前元素被使用过，做剪枝
            }
            if (cur < k) {//当前的排列组合数小于k，说明就算这一层排完了，也到不了第k个，剪枝
                k = k - cur;
                continue;
            }
            levelList.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, levelList, used, depth + 1, n, k);
        }
        return null;
    }

    //返回n的阶乘，如3!=3*2*1=6
    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res = res * n;
            n--;
        }
        return res;
    }
}
