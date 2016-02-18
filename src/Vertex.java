import java.util.Vector;

/**
 * Created by habib on 2/8/16.
 */
public class Vertex {

    public int nodeNum = -1;
    public int visiting = -1;
    public int leaving = -1;

//    public Vertex(int num, int in){ visiting = in; nodeNum = num;}

    public int vertex = -1;
    public int weight = Integer.MAX_VALUE;

    public Vertex(){}
    public Vertex(int weight){
        this.weight = weight;
    }
    public Vertex(int weight, int vertex){
        this.weight = weight;
        this.vertex = vertex;
    }
}
