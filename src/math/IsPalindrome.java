package math;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] arr = str.toCharArray();
        int left = 0;//双指针
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] != arr[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
