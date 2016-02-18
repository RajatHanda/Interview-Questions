/**
 * Created by habib on 2/15/16.
 */
public class DeepestNode{

    Node deepestNode;
    int deepestLevel = -1;
    public Node runDeepestNode(Node root){

        runDFS(root, 0);
        System.out.print(deepestLevel);
        return deepestNode;
    }

    private void runDFS(Node root, int level){

        if (root == null) return;

        if (level > deepestLevel){
            deepestLevel = level;
            deepestNode = root;
        }

        runDFS(root.left, level + 1);
        runDFS(root.right, level + 1);
    }
}
