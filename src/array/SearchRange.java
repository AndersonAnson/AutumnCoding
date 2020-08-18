package array;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }
        targetRange[0] = leftIndex;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean leftFlag) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (leftFlag && target == nums[mid])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
