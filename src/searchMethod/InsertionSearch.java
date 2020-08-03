package searchMethod;

public class InsertionSearch {
    public int insertionSearch(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + ((target - nums[left]) / (nums[right] - nums[left]) * (right - left));
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                insertionSearch(nums, target, mid + 1, right);
            } else if (nums[mid] > target) {
                insertionSearch(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

    public int insertionSearchV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((target - nums[left]) / (nums[right] - nums[left]) * (right - left));
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
