package test.huawei;

public class ProblemOne {
    //    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    示例:
//
//    输入: [-2,1,-3,4,-1,2,1,-5,4],
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大为 6。
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ProblemOne.getMax(nums));
    }

    public static int getMax(int[] nums) {
        int[] dp = new int[nums.length];
        int maxRes = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            if (dp[i] > maxRes) {
                maxRes = dp[i];
            }
        }
        return maxRes;
    }
}
