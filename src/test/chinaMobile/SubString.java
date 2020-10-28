package test.chinaMobile;

import java.util.Scanner;

public class SubString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String mainStr = sc.next();
        String subStr = sc.next();
        System.out.println(new SubString().getCount(mainStr, subStr));
    }

    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;//记录出现次数
        int index = 0;
        if (mainLength >= subLength) {
//            方式一：
//            while((index = mianStr.indexOf(subStr)) != -1 ) {//获取字符串subStr首次出现在mainStr的脚标
//                count++;
//                mianStr = mianStr.substring(index + subLength);//获取未比较的部分，赋值给被比较数组
//            }
//            方式二：改进效率
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
            return count;
        }
        return 0;
    }
}
