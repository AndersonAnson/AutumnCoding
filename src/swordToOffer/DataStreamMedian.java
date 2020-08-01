package swordToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataStreamMedian {
    private List<Double> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add((double) num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        double res = 0;
        if (list.size() % 2 != 0) {
            res = list.get(list.size() / 2);
        } else {
            res = (list.get(list.size() / 2) + list.get((list.size() / 2) - 1)) / 2;
        }
        return res;
    }
}
