/**
 * Created by habib on 2/6/16.
 */
class Node {
    public int row, col, distance;
    public Node left, right;
    public Node parent;
    public int id;

    public Node(){
        this.id = -1;
    }
    public Node(Node parent, int id){
        this.parent = parent;
        this.id = id;
    }
    public Node(int id){
        this.id = id;
    }

    public Node(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;

    }

    public boolean equals(Object o) {
        Node in = (Node) o;
        return (in.row == this.row && in.col == this.col);
    }

    public int hashCode(){
        return (this.row * 100 + this.col);
    }

}


