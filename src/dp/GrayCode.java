package dp;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> grayList = new ArrayList<>();
        grayList.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = grayList.size() - 1; j >= 0; j--) {
                grayList.add(grayList.get(j) + add);
            }
        }
        return grayList;
    }
}
