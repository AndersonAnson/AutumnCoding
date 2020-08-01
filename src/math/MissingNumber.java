package math;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
//        我们将数组中的所有数插入到一个集合中，这样每次查询操作的时间复杂度都是O(1) 的。
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!set.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    public int missingNumberV2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public int missingNumberV3(int[] nums) {
//        我们在线性时间内可以求出数组中所有数的和，并在常数时间内求出前 n+1n+1 个自然数（包括 0）的和，将后者减去前者，就得到了缺失的数字。
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
