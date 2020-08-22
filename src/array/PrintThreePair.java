package array;

public class PrintThreePair {
    public void printThreePair(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                isUniquePair(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }
    }

    public void isUniquePair(int[] arr, int f, int left, int right, int k) {
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                if (left == f + 1 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[f] + " " + arr[left] + " " + arr[right]);
                }
                left++;
                right--;
            }
        }
    }
}
