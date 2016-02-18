/**
 * Created by habib on 2/3/16.
 */
import java.util.*;


public class hashMap {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


        Map<Integer, String> hashMap = new HashMap<Integer, String>();
//        Map<Character, Integer> hashMap = new HashMap<>();


        hashMap.put(1, "Ali");
        hashMap.put(3, "Hassan");
        hashMap.put(2, "Bagher");

        for (Integer obj : hashMap.keySet()) {
            System.out.println(obj + " " + hashMap.get(obj));
        }
    }

        public TreeNode invertTree(TreeNode root) {
            if (!(root == null && root.left == null && root.right == null)){

                TreeNode leftInvertedNode = invertTree(root.left);
                TreeNode rightInvertedNode = invertTree(root.right);
                root.left = rightInvertedNode;
                root.right = leftInvertedNode;
            }

            return root;
        }



}
