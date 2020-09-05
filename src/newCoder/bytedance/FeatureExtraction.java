package newCoder.bytedance;

import java.util.*;
import java.io.*;

public class FeatureExtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //num个例子
        for (int k = 0; k < num; k++) {
            //判断几行案例
            int n = sc.nextInt();
            //记录上一行键值对的 map
            HashMap<String, Integer> map = new HashMap<>();
            //记录本行键值对的 map
            HashMap<String, Integer> temp = new HashMap<>();

            int max = 1;
            //每行案例
            for (int i = 0; i < n; i++) {
                //每一行都几个键值对
                int len = sc.nextInt();
                temp.clear();
                for (int j = 0; j < len; j++) {
                    String s = sc.nextInt() + " " + sc.nextInt();
                    temp.put(s, temp.getOrDefault(s, 0) + 1);
                }

                Set<String> set = map.keySet();
                for (String key : set) {
                    if (temp.containsKey(key)) {
                        //把上一层的有效的轨迹加到这一层
                        temp.put(key, temp.get(key) + map.get(key));
                        max = Math.max(max, temp.get(key));
                    }
                }
                map.clear();
                map.putAll(temp);
            }
            System.out.print(max);

        }
    }
}
