package searchMethod;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    public int binarySearchV2(int[] nums, int target, int low, int high) {
        //先判断如果start大于end则表示未找到相同值，返回-1；
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) { //如果中间值与key相等，则返回中间值；
                return mid;
            } else if (nums[mid] > target) { //如果中间值大于key，则向左查找；此时high =mid-1
                return binarySearchV2(nums, target, low, mid - 1);
            } else {
                //当中间值小于key时，向右边查找，此时low=mid+1
                return binarySearchV2(nums, target, mid + 1, high);
            }
        } else {
            return -1;
        }
    }

    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    public int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
}
