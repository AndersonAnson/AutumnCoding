package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len < 4) {
            return ans;
        }
        // ���������򣬷��������ȥ�ء�
        Arrays.sort(nums);
        // ��Ŀ��ֵ��������С�����ͻ�С���߱�������������ͻ��󣬱�ʾû�з����������ĸ�����
        if (target < nums[0] + nums[1] + nums[2] + nums[3]
                || target > nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4]) {
            return ans;
        }
        // ѭ���̶���һ������Ȼ��ѭ������ѡ��������������
        for (int i = 0; i < len - 3; i++) {
            // ��ͬ�ĵ�һ����ֻ�̶�һ�Σ������ظ����㡣
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // ��� target С�ڵ�ǰѭ���ܵõ�����С�ͣ�������ѭ����
            if (target < nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
                break;
            }
            // ��� target ���ڴ���ѭ�������ͣ������ѭ����һ���Ƚϴ�ĵ�һλ����
            if (target > nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
                continue;
            }
            // ѭ���̶���һ����������˫ָ�����֮��ȥѡ��������������
            for (int j = i + 1; j < len - 2; j++) {
                // ��ͬ�ĵ�һ����ֻ�̶�һ�Σ������ظ����㡣
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // ��� target С�ڵ�ǰѭ���ܵõ�����С�����ͣ�������ѭ����
                if (target < nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
                    break;
                }
                // ��� target ���ڴ���ѭ�������ͣ������ѭ����һ���Ƚϴ�ĵڶ�λ����
                if (target > nums[i] + nums[j] + nums[len - 1] + nums[len - 2]) {
                    continue;
                }
                int L = j + 1, R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    // ��������֮���� target ��С�ıȽ����ƶ���ָ�롣
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        L++;
                        while (L < R && nums[L - 1] == nums[L]) {
                            L++;
                        }
                        R--;
                        while (L < R && nums[R + 1] == nums[R]) {
                            R--;
                        }
                    } else if (sum > target) {
                        R--;
                        while (L < R && nums[R + 1] == nums[R]) {
                            R--;
                        }
                    } else {
                        L++;
                        while (L < R && nums[L - 1] == nums[L]) {
                            L++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
