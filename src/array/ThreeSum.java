package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (nums == null || length < 3) {
            return response;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    response.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;//去重
                    while (left < right && nums[right] == nums[right - 1])
                        right--;//去重
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return response;
    }
}
