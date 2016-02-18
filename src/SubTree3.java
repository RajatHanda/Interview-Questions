import java.util.List;

/**
 * Created by habib on 2/16/16.
 */
public class SubTree3{

    public Node findSubTree(List<Node> tree, Node root){
        if (root ==  null) return null;

        root.left = null;
        root.right = null;

        int countChild = 0;

        for(Node n : tree){
            if (n.parent.id == root.id)
                if (countChild == 0){
                    root.left = findSubTree(tree, n);
                    countChild++;
                }
                else{
                    root.right = findSubTree(tree, n);
                }
        }

        return root;
    }

}