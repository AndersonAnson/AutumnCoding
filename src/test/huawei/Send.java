package test.huawei;

import java.util.*;

class MemberNode {
    public String name;
    public Integer number;
    public HashSet<String> hashSet;

    public MemberNode(String name, Integer number, HashSet<String> hashSet) {
        this.name = name;
        this.number = number;
        this.hashSet = hashSet;
    }
}

public class Send {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, HashSet<String>> memberMap = new HashMap<>();
        HashMap<String, MemberNode> waibaoMap = new HashMap<>();
        HashMap<String, MemberNode> employeeMap = new HashMap<>();
        HashMap<String, MemberNode> managerMap = new HashMap<>();
        int flag = 0;
        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(str);
            if (str.equals("performance")) {
                flag = 1;
            }
            if (str.equals("organization")) {
                flag = 2;
            }
            if (str.equals("eof")) {
                break;
            }
            if (flag == 1 && !str.equals("performance")) {
                String[] split = str.split(",");
                MemberNode memberNode = new MemberNode(split[0], Integer.valueOf(split[1]), new HashSet<>());
                waibaoMap.put(split[0], memberNode);
            }
            if (flag == 2 && !str.equals("organization")) {
                String[] member = str.split(",");
                String manager = member[0];
                String employee = member[1];
                String waibao = member[2];
                if (employeeMap.containsKey(employee)) {
                    MemberNode tempMemberNode = employeeMap.get(employee);
                    tempMemberNode.hashSet.add(waibao);
                    int tempNum = waibaoMap.get(waibao).number;
                    tempMemberNode.number = tempMemberNode.number + tempNum;
                    employeeMap.put(employee, tempMemberNode);
                } else {
                    int tempNum = waibaoMap.get(waibao).number;
                    HashSet<String> set = new HashSet<>();
                    set.add(waibao);
                    MemberNode memberNode = new MemberNode(employee, tempNum, set);
                    employeeMap.put(employee, memberNode);
                }
                if (managerMap.containsKey(manager)) {
                    MemberNode tempMemberNode = managerMap.get(manager);
                    tempMemberNode.hashSet.add(employee);
                    int tempNum = employeeMap.get(employee).number;
                    tempMemberNode.number = tempMemberNode.number + tempNum;
                    managerMap.put(manager, tempMemberNode);
                } else {
                    int tempNum = employeeMap.get(employee).number;
                    HashSet<String> set = new HashSet<>();
                    set.add(employee);
                    MemberNode memberNode = new MemberNode(employee, tempNum, set);
                    managerMap.put(manager, memberNode);
                }
            }
        }
        Iterator iter = managerMap.keySet().iterator();
        for (String s : managerMap.keySet()) {

        }
    }
}
