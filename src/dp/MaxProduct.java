package dp;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp_max[i] = Math.max(dp_max[i - 1] * nums[i], Math.max(dp_min[i - 1] * nums[i], nums[i]));
            dp_min[i] = Math.min(dp_max[i - 1] * nums[i], Math.min(dp_min[i - 1] * nums[i], nums[i]));
            maxRes = Math.max(maxRes, dp_max[i]);
        }
        return maxRes;
    }

    public int maxProductV2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int dp_max = nums[0];
        int dp_min = nums[0];
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pre_dp_max = dp_max;
            dp_max = Math.max(dp_max * nums[i], Math.max(dp_min * nums[i], nums[i]));
            dp_min = Math.min(pre_dp_max * nums[i], Math.min(dp_min * nums[i], nums[i]));
            maxRes = Math.max(maxRes, dp_max);
        }
        return maxRes;
    }
}
