/**
 * Created by habib on 2/10/16.
 */
    public class LinkedNode{
        public LinkedNode next;
        public LinkedNode down;
        public NodeTree pointToTree;
        public int num;

        public LinkedNode(int in) {
            num = in;
        }

    public LinkedNode(int in, NodeTree node) {
        num = in;
        pointToTree = node;
    }

    }
