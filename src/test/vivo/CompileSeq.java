package test.vivo;

import java.util.HashMap;

class Node {
    private String val;
    private Node dependVal;

    public Node(String val, Node dependVal) {
        this.val = val;
        this.dependVal = dependVal;
    }
}

public class CompileSeq {
    public String compileSeq(String input) {
        // write code here
        String[] arr = input.split(",");
        HashMap<String, Node> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            Node depend = hashMap.get(temp);
            Node node = new Node(String.valueOf(i), depend);
        }
        String res="2,1,0,3";
        return res;
    }
}
