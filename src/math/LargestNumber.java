package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
//        从大到小排序
        Collections.sort(list, (String o1, String o2) -> (o2 + o1).compareTo(o1 + o2));
        if (list.get(0).equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < nums.length; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}