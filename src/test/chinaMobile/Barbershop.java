package test.chinaMobile;

import java.util.*;

class OldPeople {
    public int num;
    public int sex;
    public int age;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OldPeople(int num, int sex, int age) {
        this.num = num;
        this.sex = sex;
        this.age = age;
    }
}

public class Barbershop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<OldPeople> list = new ArrayList<>();
        String numStr = sc.nextLine();
        String sexStr = sc.nextLine();
        String ageStr = sc.nextLine();
        String[] numArr = numStr.split(" ");
        String[] sexArr = sexStr.split(" ");
        String[] ageArr = ageStr.split(" ");
        for (int i = 0; i < numArr.length; i++) {
            OldPeople oldPeople = new OldPeople(Integer.valueOf(numArr[i]), Integer.valueOf(sexArr[i]), Integer.valueOf(ageArr[i]));
            list.add(oldPeople);
        }
        Collections.sort(list, new Comparator<OldPeople>() {
            @Override
            public int compare(OldPeople o1, OldPeople o2) {
                int sex1 = o1.getSex();
                int sex2 = o2.getSex();
                int age1 = o1.getAge();
                int age2 = o2.getAge();
                if (sex1 < sex2) {
                    return 1;
                } else if (sex2 < sex1) {
                    return -1;
                } else {
                    if (age1 < age2) {
                        return 1;
                    } else if (age2 < age1) {
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i).getNum());
            } else {
                System.out.print(list.get(i).getNum() + " ");
            }
        }
    }
}
