import java.util.List;

/**
 * Created by habib on 2/9/16.
 */
public class NodeTree implements Comparable<NodeTree>{

    public NodeTree left, right;
    public int num;

    public NodeTree(int n){
        num = n;
    }
    public String toString(){
        return String.valueOf(num);
    }


    @Override
    public int compareTo(NodeTree o) {
        return  (num - o.num);
    }


}
