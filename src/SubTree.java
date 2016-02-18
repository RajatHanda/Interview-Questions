/**
 * Created by habib on 2/14/16.
 */
public class SubTree{
    int [][] tree;

    public SubTree(int [][] tree){
        this.tree = tree;
    }

    public Node findSubTree(int node){

        Node left = new Node(), right = new Node(), root = new Node(node);

        findChildren(node, left, right);

        if(left.id != -1)
            root.left = findSubTree(left.id);

        if(right.id != -1)
            root.right = findSubTree(right.id);

        return root;

    }

    public void findChildren(int node, Node left, Node right){
        int count = 0;

        for(int i = 0; i < tree.length && count < 2; i++){
            if(tree[i][1] == node && count == 0){
                left.id = (tree[i][0]);
                count++;
            }
            else{
                if(tree[i][1] == node && count == 1){
                    right.id  = tree[i][0];
                    count++;
                }
            }

        }


    }

    public String printSubTree(Node root){
        if (root == null) return "";

        return ("(" + printSubTree(root.left) + root.id +  printSubTree(root.right) + ")");

    }
}
