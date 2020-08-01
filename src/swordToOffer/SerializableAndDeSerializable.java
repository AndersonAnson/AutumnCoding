package swordToOffer;

public class SerializableAndDeSerializable {
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    int index = -1;

    public TreeNode DeSerialize(String str) {
        String[] tree = str.split(",");
        index++;
        int len = tree.length;
        if (index > len) {
            return null;
        }
        TreeNode tn = null;
        if (tree[index].equals("#")) {
            return null;
        } else {
            tn = new TreeNode(Integer.parseInt(tree[index]));
            tn.left = DeSerialize(str);
            tn.right = DeSerialize(str);
        }
        return tn;
    }
}
