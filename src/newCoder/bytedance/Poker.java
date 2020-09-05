package newCoder.bytedance;

import java.util.*;

public class Poker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[10];
        for (int i = 0; i < 13; i++) {
            input[Integer.parseInt(sc.next())]++;
        }
        int flag = 0;
        for (int i = 1; i <= 9; i++) {//加哪个数字
            int cnt = 0;
            if (input[i] < 4) {
                input[i]++;
                //哪个作为雀头
                for (int j = 1; j <= 9; j++) {
                    if (input[j] >= 2) {
                        input[j] -= 2;
                        if (helper(input, 1, 0)) {
                            System.out.print(i);
                            System.out.print(' ');
                            flag = 1;
                            input[j] += 2;
                            break;
                        } else {
                            input[j] += 2;
                        }
                    }
                }
                input[i]--;
            }
        }
        if (flag == 0)
            System.out.println(0);
    }

    //当前状态下，对第i个元素进行抉择，减3还是顺子还是跳过,返回true or false,当前已有cnt个顺组或者连带
    private static boolean helper(int[] input, int i, int cnt) {
        if (cnt == 4) {
            return true;
        }
        boolean flag1 = false, flag2 = false;
        if (input[i] >= 3) {
            input[i] -= 3;
            flag1 = helper(input, i, ++cnt);
            if (!flag1) {
                input[i] += 3;
                cnt--;
            } else {
                input[i] += 3;
                return true;
            }
        }
        if (input[i] > 0 && i <= 7 && input[i + 1] > 0 && input[i + 2] > 0) {
            input[i]--;
            input[i + 1]--;
            input[i + 2]--;
            flag2 = helper(input, i, ++cnt);
            if (!flag2) {
                input[i]++;
                input[i + 1]++;
                input[i + 2]++;
                cnt--;
            } else {
                input[i]++;
                input[i + 1]++;
                input[i + 2]++;
                cnt--;
                return true;
            }
        }
        return i < 9 ? helper(input, i + 1, cnt) : false;
    }
}