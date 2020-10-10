package test.huawei;

import java.util.*;

class TaskNode implements Comparator<TaskNode> {
    public int I;
    public int P;
    public int B;
    public int T;
    public int E;


    public TaskNode(int i, int p, int b, int t, int e) {
        I = i;
        P = p;
        B = b;
        T = t;
        T = e;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    @Override
    public int compare(TaskNode o1, TaskNode o2) {
        if (o1.getP() == o2.getP()) {
            if (o1.getB() == o2.getB()) {
                if (o1.getE() == o2.getE()) {
                    return 0;
                }
                return o1.getE() < o2.getE() ? -1 : 1;
            }
            return o1.getB() < o2.getB() ? -1 : 1;
        }
        return o1.getP() < o2.getP() ? -1 : 1;
    }
}

public class Management {
    public static boolean[] x;
    public static int[] y;

    public static void generate(TaskNode taskNode1, TaskNode taskNode2) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int N = sc.nextInt();
        ArrayList<TaskNode> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int I = sc.nextInt();
            int P = sc.nextInt();
            int B = sc.nextInt();
            int T = sc.nextInt();
            int End = B + T;
            if (End > E) {
                break;
            }
            TaskNode taskNode = new TaskNode(I, P, B, T, End);
            arrayList.add(taskNode);
        }
        Collections.sort(arrayList, new Comparator<TaskNode>() {
            @Override
            public int compare(TaskNode o1, TaskNode o2) {
                if (o1.getP() == o2.getP()) {
                    if (o1.getB() == o2.getB()) {
                        if (o1.getE() == o2.getE()) {
                            return 0;
                        }
                        return o1.getE() < o2.getE() ? -1 : 1;
                    }
                    return o1.getB() < o2.getB() ? -1 : 1;
                }
                return o1.getP() < o2.getP() ? -1 : 1;
            }
        });
    }
}
