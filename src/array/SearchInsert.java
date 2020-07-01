package array;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        if (target < nums[0])
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                index = i;
            } else if (nums[i] == target) {
                return i;
            }
        }
        return index + 1;
    }
}
