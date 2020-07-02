package dp;

public class RobV2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    private int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int cur = 0, pre = 0;
        int tmp = 0;
        for (int i = start; i <= end; i++) {
            tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }
        return cur;
    }
}
