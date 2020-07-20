package array;

import java.util.ArrayList;
import java.util.List;

public class YHTriangleGenerateV2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> thisLevel = new ArrayList<>();
        if (rowIndex == 1) {
            thisLevel.add(1);
            return thisLevel;
        }
        if (rowIndex == 2) {
            thisLevel.add(1);
            thisLevel.add(1);
            return thisLevel;
        }
        List<Integer> preRow = getRow(rowIndex - 1);
        thisLevel.add(1);
        for (int j = 1; j <= preRow.size() - 1; j++) {
            thisLevel.add(preRow.get(j - 1) + preRow.get(j));
        }
        thisLevel.add(1);
        return thisLevel;
    }
}
