/**
 * Created by habib on 2/14/16.
 */
import java.util.*;

public class SubTreeWithNode {
        List<Node> tree, subTree;

        public SubTreeWithNode(List<Node> tree){
            this.tree = tree;
            subTree = new ArrayList<>();
        }


    public Node findSubTree(Node root){

            findChildren(root);

            if(root.left  != null)
                findSubTree(root.left);

            if(root.right  != null)
                findSubTree(root.right);

            subTree.add(root);
            return root;

        }

        public void findChildren(Node node){
            int count = 0;

            for(int i = 0; i < tree.size() && count < 2; i++){
                if(tree.get(i).parent.id == node.id && count == 0){
                    node.left = tree.get(i);
                    count++;
                }
                else{
                    if(tree.get(i).parent.id == node.id && count == 1){
                        node.right  = tree.get(i);
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
