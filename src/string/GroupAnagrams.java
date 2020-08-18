package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            //排序
            Arrays.sort(arr);
            //映射到 key
            String thisKey = String.valueOf(arr);
            if (!hashMap.containsKey(thisKey)) {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                hashMap.put(thisKey, tempList);
            } else {
                hashMap.get(thisKey).add(strs[i]);
            }
        }
        for (String key : hashMap.keySet()) {
            res.add(hashMap.get(key));
        }
        return res;
    }
}
