package swordToOffer;

import java.util.Arrays;
import java.util.Stack;

public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
//     将数据依次放入栈中 如果pop==peek
//     空的话就添加进入栈
        Arrays.sort(array);
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (st.empty() || st.peek() != array[i]) {
                st.push(array[i]);
            } else if (st.peek() == array[i]) {
                st.pop();
            }
        }
        num1[0] = st.pop();
        num2[0] = st.pop();
    }
}
