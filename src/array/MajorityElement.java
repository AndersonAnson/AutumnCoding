package array;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElementV2(int[] nums) {
        int candidateNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidateNum == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidateNum = nums[i];
                    count = 1;
                }
            }
        }
        return candidateNum;
    }
}
