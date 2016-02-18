/**
 * Created by habib on 2/11/16.
 */
public class LinkedListCreation {

    public LinkedNode convertBTToLinkedLists(NodeTree root) {

        if (root == null) return null;
        if (root.left == null && root.right == null) return (new LinkedNode(root.num));


        NodeTree currentNodeInTree = root;
        LinkedNode head1, head2, tail2, currentNode;

        LinkedNode res = new LinkedNode(root.num, root);

        head1 = res;
        head2 = res;
        tail2 = res;
        currentNode = res;

        LinkedNode newNode;
        boolean nextLevel = true;


        while (nextLevel) {
            nextLevel = false;
            while (currentNode != null && !nextLevel) {
                currentNodeInTree = currentNode.pointToTree;
                if (currentNodeInTree.left != null && currentNodeInTree.right != null) {
                    newNode = new LinkedNode(currentNodeInTree.left.num, currentNodeInTree.left);
                    head2 = newNode;
                    tail2 = newNode;
                    head1.down = head2;

                    newNode = new LinkedNode(currentNodeInTree.right.num, currentNodeInTree.right);
                    tail2.next = newNode;
                    tail2 = tail2.next;
                    nextLevel = true;

                } else {
                    if (currentNodeInTree.left != null && currentNodeInTree.right == null) {
                        newNode = new LinkedNode(currentNodeInTree.left.num, currentNodeInTree.left);
                        head2 = newNode;
                        tail2 = newNode;
                        head1.down = head2;
                        nextLevel = true;
                    } else {
                        if (currentNodeInTree.left == null && currentNodeInTree.right != null) {
                            newNode = new LinkedNode(currentNodeInTree.right.num, currentNodeInTree.right);
                            head2 = newNode;
                            tail2 = newNode;
                            head1.down = head2;
                            nextLevel = true;
                        }
                    }

                }
                currentNode = currentNode.next;
            }


                while (currentNode != null) {
                    currentNodeInTree = currentNode.pointToTree;

                    if (currentNodeInTree.left != null && currentNodeInTree.right != null) {
                        newNode = new LinkedNode(currentNodeInTree.left.num, currentNodeInTree.left);
                        tail2.next = newNode;
                        tail2 = tail2.next;

                        newNode = new LinkedNode(currentNodeInTree.right.num, currentNodeInTree.right);
                        tail2.next = newNode;
                        tail2 = tail2.next;
                    } else {
                        if (currentNodeInTree.left != null && currentNodeInTree.right == null) {
                            newNode = new LinkedNode(currentNodeInTree.left.num, currentNodeInTree.left);
                            tail2.next = newNode;
                            tail2 = tail2.next;

                        } else {
                            if (currentNodeInTree.left == null && currentNodeInTree.right != null) {

                                newNode = new LinkedNode(currentNodeInTree.right.num, currentNodeInTree.right);
                                tail2.next = newNode;
                                tail2 = newNode;

                            }
                        }

                    }
                    currentNode = currentNode.next;
                }

                currentNode = head2;
                head1 = head2;

            }
        return res;
    }

    public void printBTLinkedList(LinkedNode root){

        if (root ==  null) return;

        LinkedNode head = root, current;
        int height = 0;



        while (head.down != null) {
            System.out.print("Height " + height + ": ");
            current = head;

            while(current != null){
                System.out.print(current.num + " ");
                current = current.next;
            }

            System.out.println();

            height++;
            head = head.down;
        }

        System.out.print("Height " + height + ": ");
        current = head;

        while(current != null){
            System.out.print(current.num + " ");
            current = current.next;
        }
    }
}
