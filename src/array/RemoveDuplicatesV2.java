package array;

public class RemoveDuplicatesV2 {
    public int removeDuplicates(int[] nums) {
        int count = 1, j = 1;
        for (int left = 1; left < nums.length; left++) {
            if (nums[left - 1] == nums[left]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j] = nums[left];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicatesV2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
