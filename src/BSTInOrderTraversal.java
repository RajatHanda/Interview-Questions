import java.util.*;

/**
 * Created by habib on 3/12/16.
 */
public class BSTInOrderTraversal {
    public static class Node{
        public int id;
        public Node left, right, parent;

        public Node(int id){
            this.id = id;
        }
    }


    public String BSTInOrderTraversalPrint(Node root){
        if (root == null) return "";

        String res = "";
        StringBuilder resBuilder = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
//        set.add(root.id);

        while(!stack.isEmpty()){
            Node current = stack.pop();

            if(current.left == null || set.contains(current.left.id)){
                if(!set.contains(current.id)) {
                    res = res + current.id + " ";
                    set.add(current.id);
                    if (current.right != null)
                        stack.push(current.right);
                }
            }

            else{
                if(current.right != null)
                    stack.push(current.right);
                stack.push(current);
                stack.push(current.left);

            }
        }


        return res;

    }


    public String BSTInOrderTraversalConstantOrderPrint(Node root){
        if (root == null) return "";

        String res = "";
        boolean leftVisited = false, rightVisited = false;
        Node currentRoot = root;

        while(!(leftVisited && rightVisited && currentRoot == null)){
            if(!leftVisited){
                if(currentRoot.left != null)
                    currentRoot = currentRoot.left;
                else{
                    leftVisited = true;
                    res += currentRoot.id + " ";
                    if(currentRoot.right != null){
                        currentRoot = currentRoot.right;
                        leftVisited = false;
                        rightVisited = false;
                    }
                    else {
                        if (currentRoot.id == currentRoot.parent.left.id) {
                            rightVisited = false;
                        } else {
                            rightVisited = true;
                        }
                        currentRoot = currentRoot.parent;
                    }

                }

            }
            else {
                if(!rightVisited){
                    res += currentRoot.id + " ";
                    if(currentRoot.right != null) {
                        currentRoot = currentRoot.right;
                        leftVisited = false;
                        rightVisited = false;
                    }
                    else {
                        if (currentRoot.id == currentRoot.parent.left.id) {
                            rightVisited = false;
                        } else {
                            rightVisited = true;
                        }
                        leftVisited = true;
                        currentRoot = currentRoot.parent;
                    }

                }
                else {
                    if(currentRoot.parent == null) {
                        currentRoot = null;
                        leftVisited = true;
                        rightVisited = true;
                    }
                    else {

                        if (currentRoot.id == currentRoot.parent.left.id) {
                            rightVisited = false;
                        } else {
                            rightVisited = true;
                        }
                        leftVisited = true;
                        currentRoot = currentRoot.parent;
                    }
                }
            }
        }


        return res;

    }

    public static void main(String[] args) {

        Node n1 = new Node(11);
        Node n2 = new Node(4);
        Node n3 = new Node(20);
        Node n4 = new Node(1);
        Node n5 = new Node(7);
        Node n6 = new Node(13);

        n1.left = n2;
        n1.right = n3;

        n2.parent = n1;
        n2.left = n4;
        n2.right = n5;

        n3.parent = n1;
        n3.left = n6;

        n4.parent = n2;

        n5.parent = n2;

        n6.parent = n3;

        BSTInOrderTraversal bst = new BSTInOrderTraversal();
        System.out.println(bst.BSTInOrderTraversalPrint(n1));
        System.out.println(bst.BSTInOrderTraversalConstantOrderPrint(n1));

    }
}
