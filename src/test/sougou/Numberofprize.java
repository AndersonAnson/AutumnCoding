package test.sougou;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Numberofprize {
    public int numberofprize(int a, int b, int c) {
        // write code here
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(a);
        linkedList.addLast(b);
        linkedList.addLast(c);
        Collections.sort(linkedList);
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(a, b));
        int res = 0;
        while (a>=2||b>=2||c>=2) {
            a=a-min;
            b=b-min;
            c=c-min;
            res=res+min;
        }
        return res;
    }
}
