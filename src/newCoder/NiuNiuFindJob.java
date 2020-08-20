package newCoder;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class NiuNiuFindJob {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        // 能力值
        int[] ability = new int[M];
        // treemap默认按照key升序排列 方便比较
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int level = sc.nextInt();
            int money = sc.nextInt();
            map.put(level, money);
        }
        for (int i = 0; i < M; i++) {
            int temp = sc.nextInt();
            ability[i] = temp;
            if (!map.containsKey(temp)) {
                map.put(temp, 0);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
            map.put(entry.getKey(), max);
        }
        for (int i = 0; i < M; i++) {
            System.out.println(map.get(ability[i]));
        }
    }
}
