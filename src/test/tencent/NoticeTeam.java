package test.tencent;

import java.util.*;

public class NoticeTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<LinkedList<Integer>> allPeople = new LinkedList<>();
        int start = 0;
        HashSet<Integer> resSet = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            LinkedList<Integer> smallTeam = new LinkedList<>();

            for (int j = 1; j <= x; j++) {
                ArrayList<Integer> team = new ArrayList<>();
                int tempNum = sc.nextInt();
                if (hashMap.containsKey(tempNum)) {
                    team = hashMap.get(tempNum);
                    team.add(i);
                    hashMap.put(tempNum, team);
                } else {
                    team.add(i);
                    hashMap.put(tempNum, team);
                }
            }

            allPeople.addLast(smallTeam);
        }
        LinkedList<Integer> startList = allPeople.get(start - 1);
    }
}
