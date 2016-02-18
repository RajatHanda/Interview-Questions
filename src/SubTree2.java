/**
 * Created by habib on 2/15/16.
 */
import java.util.*;

public class SubTree2 {
    public LinkedList<Node> findSubTree(List<Node> tree, Node root) {
        LinkedList<Node> stack = new LinkedList<>(), subTree = new LinkedList<>();

        stack.addLast(root);
        subTree.add(root);

        Node currentNode;

        while (!stack.isEmpty()) {

            currentNode = stack.removeLast();
            int i = (int)Math.pow(10, 0.3);
            for (Node node : tree) {
                if (node.parent != null && node.parent.id == currentNode.id) {
                    stack.addLast(node);
                    subTree.add(node);
                }
            }
        }
        return subTree;
    }
}