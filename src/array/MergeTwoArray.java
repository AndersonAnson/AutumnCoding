package array;

public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointA = m - 1;
        int pointB = n - 1;
        int pointC = m + n - 1;
        while (pointA >= 0 && pointB >= 0) {
            if (nums1[pointA] < nums2[pointB]) {
                nums1[pointC] = nums2[pointB];
                pointB--;
            } else {
                nums1[pointC] = nums1[pointA];
                pointA--;
            }
            pointC--;
        }
        System.arraycopy(nums2, 0, nums1, 0, pointB + 1);
    }
}
