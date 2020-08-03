package sortMethod;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
        // 设定一个标记，若为false，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        return arr;
    }
}
