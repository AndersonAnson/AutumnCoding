package array;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++) {
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum < target)
                    left++;
                else if (sum > target)
                    right--;
                else
                    return ans;
            }
        }
        return ans;
    }
}
