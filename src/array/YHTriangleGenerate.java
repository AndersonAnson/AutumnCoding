package array;

import java.util.ArrayList;
import java.util.List;

public class YHTriangleGenerate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(1);
        res.add(firstLevel);
        helper(res, firstLevel, numRows, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> level, int numRows, int depth) {
        if (depth == numRows) {
            return;
        }
        List<Integer> newLevel = new ArrayList<>();
        newLevel.add(1);
        for (int i = 0; i < level.size() - 1; i++) {
            newLevel.add(level.get(i) + level.get(i + 1));
        }
        newLevel.add(1);
        res.add(newLevel);
        depth++;
        helper(res, newLevel, numRows, depth);
    }

    public List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = res.get(rowNum - 1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
