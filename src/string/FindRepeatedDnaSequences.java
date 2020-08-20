package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet<>();
        HashSet<String> output = new HashSet<>();
        for (int start = 0; start <= n - L; start++) {
            String temp = s.substring(start, start + L);
            if (seen.contains(temp)) {
                output.add(temp);
            }
            seen.add(temp);
        }
        return new ArrayList<String>(output);
    }
}
